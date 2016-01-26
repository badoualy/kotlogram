package com.github.badoualy.telegram.tl.builder.poet

import com.github.badoualy.telegram.tl.builder.*
import com.github.badoualy.telegram.tl.builder.parser.*
import com.squareup.javapoet.*
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.*
import javax.lang.model.element.Modifier

object JavaPoet {

    private var tlDefinition = TLDefinition(emptyMap(), emptyList(), emptyList()) // Avoid to put it as nullable

    val typeClassNameMap = HashMap<TLType, ClassName>() // Map a type to it's ClassName to reference inside code
    val constructorClassNameMap = HashMap<TLConstructor, ClassName>() // Map a constructor to it's className to use when building context

    val emptyConstructorAbstractedMap = HashMap<TLConstructor, Boolean>() // Map a constructor to true if it's abstracted for an "Empty" constructor only
    val contextConstructors = ArrayList<TLConstructor>() // List of constructors to register in context

    var totalClass = 0

    val apiClazz = TypeSpec.interfaceBuilder(TELEGRAM_API_INTERFACE)
            .addModifiers(Modifier.PUBLIC)
            .addJavadoc(JAVADOC_AUTHOR).addJavadoc(JAVADOC_SEE)
            .addAnnotation(AnnotationSpec.builder(SuppressWarnings::class.java).addMember("value", "{\"unused\", \"unchecked\", \"RedundantCast\"}").build())
    var apiMethod: MethodSpec.Builder? = null

    var apiWrappedClazz = TypeSpec.classBuilder(TELEGRAM_API_WRAPPER)
            .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
            .addJavadoc(JAVADOC_AUTHOR).addJavadoc(JAVADOC_SEE)
            .addSuperinterface(TYPE_TELEGRAM_API)
            .addAnnotation(AnnotationSpec.builder(SuppressWarnings::class.java).addMember("value", "{\"unused\", \"unchecked\", \"RedundantCast\"}").build())
    var apiWrappedMethod: MethodSpec.Builder? = null

    fun writeClasses(tlDefinition: TLDefinition) {
        this.tlDefinition = tlDefinition
        println("${tlDefinition.types.size} types")

        println()
        println("Generating constructors...")
        writeConstructors()

        println()
        println("Generating methods...")
        writeMethods()

        println()
        writeContext()

        println()
        println("Generated $totalClass classes")
    }

    private fun writeConstructors() {
        val constructors = tlDefinition.constructors.sorted()
        println("${constructors.size} constructors")

        // Compute abstraction classes (multiple constructors for 1 type)
        val typeOccurrences = HashMap<TLType, Int>(tlDefinition.types.size)
        constructors.map { c -> c.tlType }.forEach { t -> typeOccurrences.put(t, typeOccurrences.getOrDefault(t, 0) + 1) }
        val nonAbstractedConstructors = constructors.filter { c -> typeOccurrences[c.tlType]!! == 1 } // No need for abstraction
        val abstractedConstructors = constructors.filter { c -> typeOccurrences[c.tlType]!! > 1 } // Need abstraction
        val abstractConstructors = ArrayList<TLAbstractConstructor>() // Fake constructor created by us

        contextConstructors.addAll(nonAbstractedConstructors)
        contextConstructors.addAll(abstractedConstructors)

        // Build AbstractConstructor
        // Check common parameters
        for (abstractType in abstractedConstructors.map { c -> c.tlType }.distinct()) {
            val typeConstructors = abstractedConstructors.filter { c -> c.tlType == abstractType }
            // We have to build an abstraction for an empty constructor, ie: TLAbsUser, TLUser, TLUserEmpty
            val abstractEmptyConstructor = typeConstructors.size == 2 && typeConstructors.map { c -> c.name.endsWith("empty", true) }.contains(true)
            if (abstractEmptyConstructor)
                typeConstructors.forEach { c -> emptyConstructorAbstractedMap.put(c, true) }
            val nonEmptyConstructor = if (!abstractEmptyConstructor) null else typeConstructors.find { c -> !c.name.endsWith("empty", true) }

            val commonParameters = typeConstructors.map { c -> c.parameters }.reduce { l1, l2 -> l1.intersect(l2).toArrayList() }
            abstractConstructors.add(TLAbstractConstructor(abstractType.name, commonParameters, abstractType, abstractEmptyConstructor))
            commonParameters.forEach { p -> p.inherited = true }

            // Update each types parameters: reference are not the same
            typeConstructors.flatMap { c -> c.parameters }.filter { p -> commonParameters.contains(p) }.forEach { p -> p.inherited = true }
        }

        // Some logging
        totalClass += nonAbstractedConstructors.size
        totalClass += abstractedConstructors.size
        totalClass += abstractConstructors.size
        println("${abstractConstructors.size} abstract classes")
        println("${nonAbstractedConstructors.size} \"direct\" classes")
        println("${abstractedConstructors.size} child classes")
        println("Total ${constructors.size + abstractConstructors.size} constructors related classes")

        // Build all classname first to be able to retrieve them when referenced in other classes
        nonAbstractedConstructors.forEach { constructor ->
            val clazzName = ClassName.get(packageName(constructor.name), className(constructor.name))
            typeClassNameMap.put(constructor.tlType, clazzName)
            constructorClassNameMap.put(constructor, clazzName)
        }
        abstractConstructors.forEach { constructor -> typeClassNameMap.put(constructor.tlType, ClassName.get(packageName(constructor.name), className(constructor.name, abstract = true))) }
        abstractedConstructors.forEach { constructor -> constructorClassNameMap.put(constructor, ClassName.get(packageName(constructor.name), className(constructor.name))) }

        // Build classes
        nonAbstractedConstructors.forEach { constructor -> writeClassToFile(JavaPoet.packageName(constructor.name), generateConstructorClass(constructor)) }
        abstractConstructors.forEach { constructor -> writeClassToFile(JavaPoet.packageName(constructor.name), generateAbstractConstructorClass(constructor)) }
        abstractedConstructors.forEach { constructor -> writeClassToFile(JavaPoet.packageName(constructor.name), generateConstructorClass(constructor, typeClassNameMap[constructor.tlType]!!)) }
    }

    private fun writeMethods() {
        val methods = tlDefinition.methods.sorted()
        totalClass += methods.size
        println("${methods.size} methods related classes")

        apiWrappedClazz.addMethod(MethodSpec.methodBuilder("executeRpcQuery")
                .addException(IOException::class.java)
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .addTypeVariable(TypeVariableName.get("T", TYPE_TL_OBJECT))
                .returns(TypeVariableName.get("T"))
                .addParameter(ParameterizedTypeName.get(TYPE_TL_METHOD, TypeVariableName.get("T")), "method")
                .build())

        methods.forEach { method -> writeClassToFile(PACKAGE_TL_API_REQUEST, generateMethodClass(method)) }

        writeClassToFile(PACKAGE_TL_API, apiClazz.build())
        writeClassToFile(PACKAGE_TL_API, apiWrappedClazz.build())
        totalClass += 2
    }

    private fun writeContext() {
        val contextClazz = TypeSpec.classBuilder(TL_API_CONTEXT)
                .addModifiers(Modifier.PUBLIC)
                .addJavadoc(JAVADOC_AUTHOR)
                .addJavadoc(JAVADOC_SEE)
                .addAnnotation(AnnotationSpec.builder(SuppressWarnings::class.java).addMember("value", "\"unused\"").build())
                .superclass(TYPE_TL_CONTEXT)

        contextClazz.addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC).addStatement("super(\$L)", contextConstructors.size + 1).build())

        contextClazz.addField(TYPE_TL_API_CONTEXT, "instance", Modifier.PRIVATE, Modifier.STATIC)

        contextClazz.addMethod(MethodSpec.methodBuilder("getInstance")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(TYPE_TL_API_CONTEXT)
                .beginControlFlow("if (instance == null)")
                .addStatement("instance = new \$T()", TYPE_TL_API_CONTEXT)
                .endControlFlow()
                .addStatement("return instance")
                .build())

        val methodBuilder = MethodSpec.methodBuilder("init").addModifiers(Modifier.PUBLIC).addAnnotation(Override::class.java)
        methodBuilder.addStatement("registerClass(\$T.CLASS_ID, \$T.class" + ")", TYPE_TL_VECTOR, TYPE_TL_VECTOR)
        for (constructor in contextConstructors.sorted()) {
            val clazzName = constructorClassNameMap[constructor]!!
            methodBuilder.addStatement("registerClass(\$T.CLASS_ID, \$T.class" + ")", clazzName, clazzName)
        }
        contextClazz.addMethod(methodBuilder.build())

        writeClassToFile(PACKAGE_TL_API, contextClazz.build())
        totalClass++
    }

    private fun generateAbstractConstructorClass(constructor: TLAbstractConstructor): TypeSpec {
        val clazzName = className(constructor.name, abstract = true)
        val clazz = TypeSpec.classBuilder(clazzName)
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .addJavadoc(JAVADOC_AUTHOR)
                .addJavadoc(JAVADOC_SEE)
                .superclass(TYPE_TL_OBJECT)

        generateClassCommon(clazz, constructor.name, null, constructor.parameters)

        if (constructor.abstractEmptyConstructor) {
            val constructors = contextConstructors.filter { c -> c.tlType == constructor.tlType }
            val nonEmptyConstructor = constructors.find { c -> !c.name.endsWith("empty", true) }
            val emptyConstructor = constructors.find { c -> c.name.endsWith("empty", true) }

            clazz.addMethod(MethodSpec.methodBuilder("isEmpty")
                    .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                    .returns(TypeName.BOOLEAN)
                    .build())

            clazz.addMethod(MethodSpec.methodBuilder("isNotEmpty")
                    .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                    .returns(TypeName.BOOLEAN)
                    .build())

            clazz.addMethod(MethodSpec.methodBuilder("getAs" + constructor.name.uFirstLetter())
                    .addModifiers(Modifier.PUBLIC)
                    .returns(constructorClassNameMap[nonEmptyConstructor])
                    .addStatement("return null")
                    .build())

            if (constructor.name.startsWith("input", true)) {
                clazz.addMethod(MethodSpec.methodBuilder("newEmpty")
                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                        .returns(constructorClassNameMap[emptyConstructor])
                        .addStatement("return new \$T()", constructorClassNameMap[emptyConstructor])
                        .build())

                clazz.addMethod(MethodSpec.methodBuilder("newNotEmpty")
                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                        .returns(constructorClassNameMap[nonEmptyConstructor])
                        .addStatement("return new \$T()", constructorClassNameMap[nonEmptyConstructor])
                        .build())
            }
        }

        return clazz.build()
    }

    private fun generateConstructorClass(constructor: TLConstructor, superclass: ClassName = TYPE_TL_OBJECT): TypeSpec {
        val clazz = TypeSpec.classBuilder(className(constructor.name))
                .addModifiers(Modifier.PUBLIC)
                .addJavadoc(JAVADOC_AUTHOR)
                .addJavadoc(JAVADOC_SEE)
                .superclass(superclass)

        generateClassCommon(clazz, constructor.name, constructor.id, constructor.parameters)

        if (emptyConstructorAbstractedMap.getOrDefault(constructor, false)) {
            clazz.addMethod(MethodSpec.methodBuilder("isEmpty")
                    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                    .addAnnotation(Override::class.java)
                    .returns(TypeName.BOOLEAN)
                    .addStatement("return \$L", constructor.name.endsWith("empty", true))
                    .build())

            clazz.addMethod(MethodSpec.methodBuilder("isNotEmpty")
                    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                    .addAnnotation(Override::class.java)
                    .returns(TypeName.BOOLEAN)
                    .addStatement("return \$L", !constructor.name.endsWith("empty", true))
                    .build())

            if (!constructor.name.endsWith("empty", true)) {
                clazz.addMethod(MethodSpec.methodBuilder("getAs" + constructor.name.uFirstLetter())
                        .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                        .addAnnotation(Override::class.java)
                        .returns(constructorClassNameMap[constructor])
                        .addStatement("return this")
                        .build())
            }
        }

        return clazz.build()
    }

    private fun generateMethodClass(method: TLMethod): TypeSpec {
        val clazzName = className(method.name, request = true)
        val responseType = getType(method.tlType, true)
        val clazz = TypeSpec.classBuilder(clazzName)
                .addModifiers(Modifier.PUBLIC)
                .addJavadoc(JAVADOC_AUTHOR)
                .addJavadoc(JAVADOC_SEE)
                .superclass(ParameterizedTypeName.get(TYPE_TL_METHOD, responseType))

        val deserializeResponseMethod = MethodSpec.methodBuilder("deserializeResponse")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override::class.java)
                .addAnnotation(AnnotationSpec.builder(SuppressWarnings::class.java).addMember("value", "\"unchecked\"").build())
                .addParameter(InputStream::class.java, "stream")
                .addParameter(TYPE_TL_CONTEXT, "context")
                .addException(IOException::class.java)
                .returns(responseType)
        if (method.tlType is TLTypeAny) {
            clazz.addTypeVariable(TypeVariableName.get("T", TYPE_TL_OBJECT))

            // Delegate
            deserializeResponseMethod.addStatement("return query.deserializeResponse(stream, context)", TypeVariableName.get("T"))
        } else {
            deserializeResponseMethod.addStatement("final \$T response = readTLObject(stream, context)", TYPE_TL_OBJECT)
                    .beginControlFlow("if (response == null)")
                    .addStatement("throw new \$T(\"Unable to parse response\")", IOException::class.java)
                    .endControlFlow();

            if (method.tlType is TLTypeGeneric)
                deserializeResponseMethod.beginControlFlow("if (!(response instanceof \$T))", TYPE_TL_VECTOR)
            else
                deserializeResponseMethod.beginControlFlow("if (!(response instanceof \$T))", responseType)

            deserializeResponseMethod.addStatement("throw new \$T(\"Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()\")", IOException::class.java)
                    .endControlFlow()
                    .addStatement("return (\$T) response", responseType)
        }
        clazz.addMethod(deserializeResponseMethod.build())

        apiMethod = MethodSpec.methodBuilder(method.name.lCamelCase())
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .addException(IOException::class.java)
                .returns(responseType)
        apiWrappedMethod = MethodSpec.methodBuilder(method.name.lCamelCase())
                .addModifiers(Modifier.PUBLIC).addAnnotation(Override::class.java)
                .addException(IOException::class.java)
                .returns(responseType)
                .addStatement("return (\$T) executeRpcQuery(new \$T(\$L))",
                        responseType,
                        ClassName.get(PACKAGE_TL_API_REQUEST, clazzName),
                        if (method.parameters.isNotEmpty()) method.parameters.map { p -> p.name.lCamelCase().javaEscape() }.joinToString(", ") else "")
        generateClassCommon(clazz, method.name, method.id, method.parameters)
        apiClazz.addMethod(apiMethod?.build())
        apiWrappedClazz.addMethod(apiWrappedMethod?.build())
        apiMethod = null
        apiWrappedMethod = null

        return clazz.build()
    }

    private fun generateClassCommon(clazz: TypeSpec.Builder, name: String, id: Int?, parameters: List<TLParameter>) {
        if (id != null) {
            // CLASS_ID field
            clazz.addField(FieldSpec.builder(TypeName.INT, "CLASS_ID", Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                    .initializer("0x${hex(id)}").build())
        }

        // Empty constructor
        clazz.addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC).build());
        val constructorBuilder = MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC)

        // Serialize
        val serializeMethod = MethodSpec.methodBuilder("serializeBody")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override::class.java)
                .addException(IOException::class.java)
                .addParameter(OutputStream::class.java, "stream")

        // Unserialize
        val deserializeMethod = MethodSpec.methodBuilder("deserializeBody")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override::class.java)
                .addAnnotation(AnnotationSpec.builder(SuppressWarnings::class.java).addMember("value", "\"unchecked\"").build())
                .addException(IOException::class.java)
                .addParameter(InputStream::class.java, "stream")
                .addParameter(TYPE_TL_CONTEXT, "context")

        // Compute flag for serialization
        val condParameters = parameters.filter { p -> p.tlType is TLTypeConditional }
        if (condParameters.isNotEmpty()) {
            serializeMethod.addStatement("flags = 0")
            for (parameter in condParameters) {
                val tlType = parameter.tlType as TLTypeConditional
                val realType = tlType.realType
                val fieldType = getType(realType)
                val fieldName = parameter.name.lCamelCase().javaEscape()

                if (fieldType == TypeName.BOOLEAN)
                    serializeMethod.addStatement("flags = $fieldName ? (flags | ${tlType.pow2Value()}) : (flags &~ ${tlType.pow2Value()})")
            }

            serializeMethod.addCode("\n")
        }

        // Parameters
        val accessors = ArrayList<MethodSpec>()
        for (parameter in parameters) {
            val fieldType = getType(parameter.tlType)
            val fieldName = parameter.name.lCamelCase().javaEscape()
            if (!parameter.inherited || id == null) // Null-id is superclass
                clazz.addField(fieldType, fieldName, Modifier.PROTECTED)

            // Add set()/get()
            accessors.add(generateGetter(parameter.name, fieldName, fieldType))
            accessors.add(generateSetter(parameter.name, fieldName, fieldType))

            // Add constructor parameter
            constructorBuilder.addParameter(fieldType, fieldName)
            constructorBuilder.addStatement("this.$fieldName = $fieldName")

            // Add serialize method entry
            serializeMethod.addStatement(serializeParameter(fieldName, parameter.tlType))
            deserializeMethod.addStatement(deserializeParameter(fieldName, parameter.tlType, fieldType))

            // Add api method
            apiMethod?.addParameter(fieldType, fieldName)
            apiWrappedMethod?.addParameter(fieldType, fieldName)
            if (parameter.tlType is TLTypeFunctional) {
                apiMethod?.addTypeVariable(TypeVariableName.get("T", TYPE_TL_OBJECT))
                apiWrappedMethod?.addTypeVariable(TypeVariableName.get("T", TYPE_TL_OBJECT))
            }
        }

        if (id != null) {
            if (parameters.isNotEmpty()) {
                clazz.addMethod(constructorBuilder.build())
                clazz.addMethod(serializeMethod.build())
                clazz.addMethod(deserializeMethod.build())
            }

            // toString()
            clazz.addMethod(MethodSpec.methodBuilder("toString")
                    .addAnnotation(Override::class.java)
                    .addModifiers(Modifier.PUBLIC)
                    .returns(String::class.java)
                    .addStatement("""return "$name#${hex(id)}"""")
                    .build())

            // getClassId
            clazz.addMethod(MethodSpec.methodBuilder("getClassId")
                    .addAnnotation(Override::class.java)
                    .addModifiers(Modifier.PUBLIC)
                    .returns(TypeName.INT)
                    .addStatement("return CLASS_ID")
                    .build())
        }
        clazz.addMethods(accessors)
    }

    private fun getType(type: TLType, boxedInTl: Boolean = false): TypeName = when (type) {
        is TLTypeFunctional -> ParameterizedTypeName.get(TYPE_TL_METHOD, TypeVariableName.get("T")) // ex: InitConnection
        is TLTypeAny -> TypeVariableName.get("T")
        is TLTypeFlag -> TypeName.INT
        is TLTypeConditional -> getType(type.realType)
        is TLTypeGeneric -> ParameterizedTypeName.get(TYPE_TL_VECTOR, getType(type.generics.first()).box())
        is TLTypeRaw -> {
            val name = type.name
            when (name) {
                "int" -> TypeName.INT
                "long" -> TypeName.LONG
                "double" -> TypeName.DOUBLE
                "float" -> TypeName.FLOAT
                "string" -> TypeName.get(String::class.java)
                "bytes" -> TYPE_TL_BYTES // TODO: wrap in bytes[], figure out offset/length
                "Bool" -> if (boxedInTl) TYPE_TL_BOOL else TypeName.BOOLEAN
                else -> typeClassNameMap[type]!!
            }
        }
        else -> throw RuntimeException("Unsupported type $type")
    }

    private fun serializeParameter(fieldName: String, fieldTlType: TLType): String = when (fieldTlType) {
        is TLTypeFunctional -> "writeTLMethod($fieldName, stream)"
        is TLTypeFlag -> "writeInt($fieldName, stream)"
        is TLTypeConditional -> "if ((flags & ${fieldTlType.pow2Value()}) != 0) ${serializeParameter(fieldName, fieldTlType.realType)}"
        is TLTypeGeneric -> "writeTLVector($fieldName, stream)"
        is TLTypeRaw -> {
            val name = fieldTlType.name
            when (name) {
                "int" -> "writeInt($fieldName, stream)"
                "long" -> "writeLong($fieldName, stream)"
                "double" -> "writeDouble($fieldName, stream)"
                "float" -> "writeFloat($fieldName, stream)"
                "string" -> "writeTLString($fieldName, stream)"
                "bytes" -> "writeTLBytes($fieldName, stream)"
                "Bool" -> "writeTLBool($fieldName, stream)"
                else -> "writeTLObject($fieldName, stream)"
            }
        }
        else -> throw RuntimeException("Unsupported type $fieldTlType")
    }

    private fun deserializeParameter(fieldName: String, fieldTlType: TLType, fieldType: TypeName): String = when (fieldTlType) {
        is TLTypeFunctional -> "$fieldName = readTLMethod(stream, context)"
        is TLTypeFlag -> "$fieldName = readInt(stream)"
        is TLTypeConditional -> {
            val realType = fieldTlType.realType
            if (realType is TLTypeRaw && arrayOf("Bool", "true").contains(realType.name))
                "$fieldName = (flags & ${fieldTlType.pow2Value()}) != 0"
            else
                "if ((flags & ${fieldTlType.pow2Value()}) != 0) ${deserializeParameter(fieldName, realType, fieldType)}"
        }
        is TLTypeGeneric -> "$fieldName = readTLVector(stream, context)"
        is TLTypeRaw -> {
            val name = fieldTlType.name
            when (name) {
                "int" -> "$fieldName = readInt(stream)"
                "long" -> "$fieldName = readLong(stream)"
                "double" -> "$fieldName = readDouble(stream)"
                "float" -> "$fieldName = readFloat(stream)"
                "string" -> "$fieldName = readTLString(stream)"
                "bytes" -> "$fieldName = readTLBytes(stream, context)"
                "Bool" -> "$fieldName = readTLBool(stream)"
                else -> {
                    // TODO
                    val fieldClassName = fieldType as ClassName
                    "$fieldName = (${"${(fieldClassName).packageName()}.${fieldClassName.simpleName()}"}) readTLObject(stream, context)"
                }
            }
        }
        else -> throw RuntimeException("Unsupported type $fieldTlType")
    }

    private fun generateGetter(realName: String, fieldName: String, fieldType: TypeName): MethodSpec {
        return MethodSpec.methodBuilder("get${realName.uCamelCase()}")
                .addModifiers(Modifier.PUBLIC)
                .returns(fieldType)
                .addStatement("return $fieldName")
                .build()
    }

    private fun generateSetter(realName: String, fieldName: String, fieldType: TypeName): MethodSpec {
        return MethodSpec.methodBuilder("set${realName.uCamelCase()}")
                .addModifiers(Modifier.PUBLIC)
                .addParameter(fieldType, fieldName)
                .addStatement("this.$fieldName = $fieldName")
                .build()
    }

    private fun writeClassToFile(packageName: String, clazz: TypeSpec) {
        JavaFile.builder(packageName, clazz)
                .addStaticImport(TYPE_STREAM_UTILS, "*")
                .indent("    ")
                .build().writeTo(File(OUTPUT))
    }

    private fun className(typeName: String, abstract: Boolean = false, request: Boolean = false) = when {
        abstract -> "TLAbs${typeName.split('.').last().uFirstLetter()}"
        request -> "TLRequest${typeName.uCamelCase()}"
        else -> "TL${typeName.split('.').last().uFirstLetter()}"
    }

    private fun packageName(typeName: String): String {
        var suffix = ""
        val subPackage = typeName.split('.').dropLast(1).joinToString(".")
        if (subPackage.isNotBlank()) suffix += ".$subPackage"
        return PACKAGE_TL_API + suffix
    }
}