package com.github.badoualy.telegram.tl.builder.poet

import com.github.badoualy.telegram.tl.builder.*
import com.github.badoualy.telegram.tl.builder.parser.*
import com.squareup.javapoet.*
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
    val testContext = ArrayList<ClassName>() // List of types for test context (contextConstructors + methods)

    var totalClass = 0

    val apiClazz = TypeSpec.interfaceBuilder(TELEGRAM_API_INTERFACE)
            .addModifiers(Modifier.PUBLIC)
            .addJavadoc(JAVADOC_AUTHOR).addJavadoc(JAVADOC_SEE)
            .addAnnotation(AnnotationSpec.builder(SuppressWarnings::class.java).addMember("value", "{\"unused\", \"unchecked\", \"RedundantCast\"}").build())!!
    var apiMethod: MethodSpec.Builder? = null

    var apiWrappedClazz = TypeSpec.classBuilder(TELEGRAM_API_WRAPPER)
            .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
            .addJavadoc(JAVADOC_AUTHOR).addJavadoc(JAVADOC_SEE)
            .addSuperinterface(TYPE_TELEGRAM_API)
            .addAnnotation(AnnotationSpec.builder(SuppressWarnings::class.java).addMember("value", "{\"unused\", \"unchecked\", \"RedundantCast\"}").build())!!
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
        println("Generating context...")
        writeContext()

        println()
        println("Generating test context...")
        writeTestContext()

        println()
        println("Generated $totalClass classes")
    }

    private fun writeConstructors() {
        val constructors = tlDefinition.constructors.sorted()
        println("${constructors.size} constructors")

        // Compute abstraction classes (multiple constructors for 1 type)
        val typeOccurrences = HashMap<TLType, Int>(tlDefinition.types.size)
        constructors.map { it.tlType }.forEach { typeOccurrences.put(it, typeOccurrences.getOrDefault(it, 0) + 1) }
        val nonAbstractedConstructors = constructors.filter { typeOccurrences[it.tlType]!! == 1 } // No need for abstraction
        val abstractedConstructors = constructors.filter { typeOccurrences[it.tlType]!! > 1 } // Need abstraction
        val abstractConstructors = ArrayList<TLAbstractConstructor>() // Fake constructor created by us

        contextConstructors.addAll(nonAbstractedConstructors)
        contextConstructors.addAll(abstractedConstructors)

        // Build AbstractConstructor
        // Check common parameters
        for (abstractType in abstractedConstructors.map { it.tlType }.distinct()) {
            val typeConstructors = abstractedConstructors.filter { it.tlType == abstractType }
            // We have to build an abstraction for an empty constructor, ie: TLAbsUser, TLUser, TLUserEmpty
            val abstractEmptyConstructor = typeConstructors.size == 2 && typeConstructors.map { it.name.endsWith("empty", true) }.contains(true)
            if (abstractEmptyConstructor)
                typeConstructors.forEach { emptyConstructorAbstractedMap.put(it, true) }
            //val nonEmptyConstructor = if (!abstractEmptyConstructor) null else typeConstructors.find { c -> !c.name.endsWith("empty", true) }

            val commonParameters = typeConstructors.map { it.parameters }.reduce { l1, l2 -> ArrayList(l1.intersect(l2)) }
            abstractConstructors.add(TLAbstractConstructor(abstractType.name, commonParameters, abstractType, abstractEmptyConstructor))
            commonParameters.forEach { it.inherited = true }

            // Update each types parameters: reference are not the same
            typeConstructors.flatMap { it.parameters }.filter { commonParameters.contains(it) }.forEach { it.inherited = true }
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
                                          .addException(TYPE_RPC_EXCEPTION).addException(IOException::class.java)
                                          .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                                          .addTypeVariable(TypeVariableName.get("T", TYPE_TL_OBJECT))
                                          .returns(TypeVariableName.get("T"))
                                          .addParameter(ParameterizedTypeName.get(TYPE_TL_METHOD, TypeVariableName.get("T")), "method")
                                          .build())

        methods.forEach { method -> writeClassToFile(PACKAGE_TL_API_REQUEST, generateMethodClass(method)) }

        writeClassToFile(PACKAGE_TL_API, apiClazz.build(), OUTPUT)
        writeClassToFile(PACKAGE_TL_API, apiWrappedClazz.build(), OUTPUT)
        totalClass += 2
    }

    private fun writeContext() {
        val contextClazz = TypeSpec.classBuilder(TL_API_CONTEXT)
                .addModifiers(Modifier.PUBLIC)
                .addJavadoc(JAVADOC_AUTHOR)
                .addJavadoc(JAVADOC_SEE)
                .addAnnotation(AnnotationSpec.builder(SuppressWarnings::class.java).addMember("value", "\"unused\"").build())
                .superclass(TYPE_TL_CONTEXT)

        contextClazz.addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC).addStatement("super(\$L)", contextConstructors.size).build())

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
        for (constructor in contextConstructors.sorted()) {
            val clazzName = constructorClassNameMap[constructor]!!
            methodBuilder.addStatement("registerClass(\$T.CONSTRUCTOR_ID, \$T.class" + ")", clazzName, clazzName)
        }
        contextClazz.addMethod(methodBuilder.build())

        writeClassToFile(PACKAGE_TL_API, contextClazz.build())
        totalClass++
    }


    private fun writeTestContext() {
        val contextClazz = TypeSpec.classBuilder(TL_API_TEST_CONTEXT)
                .addModifiers(Modifier.PUBLIC)
                .addJavadoc(JAVADOC_AUTHOR)
                .addJavadoc(JAVADOC_SEE)
                .addAnnotation(AnnotationSpec.builder(SuppressWarnings::class.java).addMember("value", "\"unused\"").build())
                .superclass(TYPE_TL_CONTEXT)

        contextClazz.addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC).addStatement("super(\$L)", testContext.size).build())

        contextClazz.addField(TYPE_TL_API_TEST_CONTEXT, "instance", Modifier.PRIVATE, Modifier.STATIC)

        contextClazz.addMethod(MethodSpec.methodBuilder("getInstance")
                                       .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                                       .returns(TYPE_TL_API_TEST_CONTEXT)
                                       .beginControlFlow("if (instance == null)")
                                       .addStatement("instance = new \$T()", TYPE_TL_API_TEST_CONTEXT)
                                       .endControlFlow()
                                       .addStatement("return instance")
                                       .build())

        val methodBuilder = MethodSpec.methodBuilder("init").addModifiers(Modifier.PUBLIC).addAnnotation(Override::class.java)
        for (clazzType in testContext.sortedBy { it.simpleName() }) {
            methodBuilder.addStatement("registerClass(\$T.CONSTRUCTOR_ID, \$T.class" + ")", clazzType, clazzType)
        }
        contextClazz.addMethod(methodBuilder.build())

        writeClassToFile(PACKAGE_TL_API, contextClazz.build(), OUTPUT_TEST)
        totalClass++
    }

    private fun generateAbstractConstructorClass(constructor: TLAbstractConstructor): TypeSpec {
        val clazzName = className(constructor.name, abstract = true)
        val clazz = TypeSpec.classBuilder(clazzName)
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .superclass(TYPE_TL_OBJECT)

        generateClassCommon(clazz, ClassName.get("", clazzName), constructor.name, null, constructor.parameters)

        val constructors = contextConstructors.filter { c -> c.tlType == constructor.tlType }
        clazz.addJavadoc("Abstraction level for the following constructors:\n")
                .addJavadoc("<ul>\n")
        constructors.forEach { clazz.addJavadoc("<li>{@link ${constructorClassNameMap[it].toString().substringAfterLast('.')}}: ${it.name}#${hex(it.id)}</li>\n") }
        clazz.addJavadoc("</ul>\n\n")

        if (constructor.abstractEmptyConstructor) {
            val nonEmptyConstructor = constructors.find { c -> !c.name.endsWith("empty", true) }!!
            val emptyConstructor = constructors.find { c -> c.name.endsWith("empty", true) }!!

            clazz.addMethod(MethodSpec.methodBuilder("isEmpty")
                                    .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                                    .returns(TypeName.BOOLEAN)
                                    .build())

            clazz.addMethod(MethodSpec.methodBuilder("isNotEmpty")
                                    .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                                    .returns(TypeName.BOOLEAN)
                                    .build())

            clazz.addMethod(MethodSpec.methodBuilder("getAs" + nonEmptyConstructor.name.split(".").last().uCamelCase())
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

        return clazz
                .addJavadoc(JAVADOC_AUTHOR)
                .addJavadoc(JAVADOC_SEE)
                .build()
    }

    private fun generateConstructorClass(constructor: TLConstructor, superclass: ClassName = TYPE_TL_OBJECT): TypeSpec {
        val clazz = TypeSpec.classBuilder(className(constructor.name))
                .addModifiers(Modifier.PUBLIC)
                .superclass(superclass)
        val clazzTypeName = constructorClassNameMap[constructor]!!

        generateClassCommon(clazz, clazzTypeName, constructor.name, constructor.id, constructor.parameters)

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
                clazz.addMethod(MethodSpec.methodBuilder("getAs" + constructor.name.split(".").last().uCamelCase())
                                        .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                                        .addAnnotation(Override::class.java)
                                        .returns(clazzTypeName)
                                        .addStatement("return this")
                                        .build())
            }
        }

        return clazz
                .addJavadoc(JAVADOC_AUTHOR)
                .addJavadoc(JAVADOC_SEE)
                .build()
    }

    private fun generateMethodClass(method: TLMethod): TypeSpec {
        val clazzName = className(method.name, request = true)
        val responseType = getType(method.tlType, true)
        val clazzTypeName = ClassName.get(PACKAGE_TL_API_REQUEST, clazzName)
        val clazz = TypeSpec.classBuilder(clazzName)
                .addModifiers(Modifier.PUBLIC)
                .addJavadoc(JAVADOC_AUTHOR)
                .addJavadoc(JAVADOC_SEE)
                .superclass(ParameterizedTypeName.get(TYPE_TL_METHOD, responseType))

        val deserializeResponseMethod = MethodSpec.methodBuilder("deserializeResponse")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override::class.java)
                .addAnnotation(AnnotationSpec.builder(SuppressWarnings::class.java).addMember("value", """{"unchecked", "SimplifiableConditionalExpression"}""").build())
                .addParameter(InputStream::class.java, "stream")
                .addParameter(TYPE_TL_CONTEXT, "context")
                .addException(IOException::class.java)
                .returns(responseType)
        if (method.tlType is TLTypeAny) {
            clazz.addTypeVariable(TypeVariableName.get("T", TYPE_TL_OBJECT))

            // Delegate
            deserializeResponseMethod.addStatement("return query.deserializeResponse(stream, context)", TypeVariableName.get("T"))
        } else if (method.tlType is TLTypeGeneric) {
            when (responseType) {
                TYPE_TL_INT_VECTOR -> deserializeResponseMethod.addStatement("return readTLIntVector(stream, context)")
                TYPE_TL_LONG_VECTOR -> deserializeResponseMethod.addStatement("return readTLLongVector(stream, context)")
                TYPE_TL_STRING_VECTOR -> deserializeResponseMethod.addStatement("return readTLStringVector(stream, context)")
                else -> deserializeResponseMethod.addStatement("return readTLVector(stream, context)")
            }
        } else {
            deserializeResponseMethod.addStatement("final \$T response = readTLObject(stream, context)", TYPE_TL_OBJECT)
                    .beginControlFlow("if (response == null)")
                    .addStatement("throw new \$T(\"Unable to parse response\")", IOException::class.java)
                    .endControlFlow()

                    .beginControlFlow("if (!(response instanceof \$T))", if (responseType is ParameterizedTypeName) responseType.rawType else responseType)
                    .addStatement("throw new \$T(\"Incorrect response type, expected \" + getClass().getCanonicalName() + \", found \" + response.getClass().getCanonicalName())", IOException::class.java)
                    .endControlFlow()

                    .addStatement("return (\$T) response", responseType)
        }
        clazz.addMethod(deserializeResponseMethod.build())

        apiMethod = MethodSpec.methodBuilder(method.name.lCamelCase())
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .addException(TYPE_RPC_EXCEPTION).addException(IOException::class.java)
                .returns(responseType)
        apiWrappedMethod = MethodSpec.methodBuilder(method.name.lCamelCase())
                .addModifiers(Modifier.PUBLIC).addAnnotation(Override::class.java)
                .addException(TYPE_RPC_EXCEPTION).addException(IOException::class.java)
                .returns(responseType)
                .addStatement("return (\$T) executeRpcQuery(new \$T(\$L))",
                              responseType,
                              clazzTypeName,
                              if (method.parameters.isNotEmpty())
                                  method.parameters.filterNot { it.tlType is TLTypeFlag }.map { it.name.lCamelCase().javaEscape() }.joinToString(", ")
                              else "")
        generateClassCommon(clazz, clazzTypeName, method.name, method.id, method.parameters)
        apiClazz.addMethod(apiMethod?.build())
        apiWrappedClazz.addMethod(apiWrappedMethod?.build())
        apiMethod = null
        apiWrappedMethod = null

        return clazz.build()
    }

    private fun generateClassCommon(clazz: TypeSpec.Builder, clazzTypeName: ClassName?, name: String, id: Int?, parameters: List<TLParameter>) {
        if (id != null) {
            // CONSTRUCTOR_ID field
            clazz.addField(FieldSpec.builder(TypeName.INT, "CONSTRUCTOR_ID", Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                                   .initializer("0x${hex(id)}").build())

            if (clazzTypeName != null)
                testContext.add(clazzTypeName)
        }

        // Empty constructor
        clazz.addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC).build())
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
                .addAnnotation(AnnotationSpec.builder(SuppressWarnings::class.java).addMember("value", """{"unchecked", "SimplifiableConditionalExpression"}""").build())
                .addException(IOException::class.java)
                .addParameter(InputStream::class.java, "stream")
                .addParameter(TYPE_TL_CONTEXT, "context")

        // Compute serializedSize
        val computeSizeMethod = MethodSpec.methodBuilder("computeSerializedSize")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override::class.java)
                .returns(TypeName.INT)

        // Equals
        val equalsStatements = ArrayList<String>()
        val equalsMethod = MethodSpec.methodBuilder("equals")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override::class.java)
                .addAnnotation(AnnotationSpec.builder(SuppressWarnings::class.java).addMember("value", "\$S", "PointlessBooleanExpression").build())
                .returns(TypeName.BOOLEAN)
                .addParameter(Any::class.java, "object")
                .addStatement("if (!(object instanceof \$L)) return false", clazzTypeName?.simpleName())
                .addStatement("if (object == this) return true")
                .addCode("\n")
                .addStatement("\$T o = (\$T) object", clazzTypeName, clazzTypeName)
                .addCode("\n")

        // Compute flag for serialization
        val condParameters = parameters.filter { it.tlType is TLTypeConditional }
        if (condParameters.isNotEmpty() && id != null) {
            val computeFlagsMethod = MethodSpec.methodBuilder("computeFlags")
                    .addModifiers(Modifier.PRIVATE)

            val condBoolean = ArrayList<TLParameter>()

            computeFlagsMethod.addStatement("flags = 0")
            for (parameter in condParameters) {
                val tlType = parameter.tlType as TLTypeConditional
                val realType = tlType.realType
                val fieldName = parameter.name.lCamelCase().javaEscape()

                if (realType is TLTypeRaw && arrayOf("true", "false").contains(realType.name)) {
                    computeFlagsMethod.addStatement("flags = $fieldName ? (flags | ${tlType.pow2Value()}) : (flags & ~${tlType.pow2Value()})")
                    if (condParameters.any {
                        (it != parameter
                                && !((it.tlType as TLTypeConditional).realType is TLTypeRaw && (it.tlType.realType as TLTypeRaw).name == "Bool")
                                && (it.tlType as TLTypeConditional).value == tlType.value)
                    })
                        condBoolean.add(parameter)
                } else {
                    if (realType is TLTypeRaw && realType.name == "Bool" && condParameters.any { it != parameter && (it.tlType as TLTypeConditional).value == tlType.value }) {
                        computeFlagsMethod.addCode("// If field is not serialized force it to false\n")
                        computeFlagsMethod.addStatement("if ($fieldName && (flags & ${tlType.pow2Value()}) == 0) $fieldName = false")
                    } else {
                        computeFlagsMethod.addStatement("flags = $fieldName != null ? (flags | ${tlType.pow2Value()}) : (flags & ~${tlType.pow2Value()})")
                    }
                }
            }

            if (condBoolean.isNotEmpty()) {
                computeFlagsMethod.addCode("\n// Following parameters might be forced to true by another field that updated the flags\n")
                for (parameter in condBoolean) {
                    computeFlagsMethod.addStatement("" + parameter.name.lCamelCase().javaEscape() + " = (flags & ${(parameter.tlType as TLTypeConditional).pow2Value()}) != 0")
                }
            }

            clazz.addMethod(computeFlagsMethod.build())

            serializeMethod.addStatement("computeFlags()")
            serializeMethod.addCode("\n")

            computeSizeMethod.addStatement("computeFlags()")
            computeSizeMethod.addCode("\n")
        }

        computeSizeMethod.addStatement("int size = SIZE_CONSTRUCTOR_ID")

        // Parameters
        val accessors = ArrayList<MethodSpec>()
        for (parameter in parameters) {
            val fieldTlType = parameter.tlType
            var fieldType = getType(fieldTlType)
            if (fieldType is ParameterizedTypeName
                    && (fieldTlType is TLTypeGeneric
                    || (fieldTlType is TLTypeConditional && fieldTlType.realType is TLTypeGeneric))) {
                //val typeArg = WildcardTypeName.subtypeOf(fieldType.typeArguments.first()) TODO FIX
                val typeArg = fieldType.typeArguments.first()
                fieldType = ParameterizedTypeName.get(fieldType.rawType, typeArg)
            }
            // Build field
            val fieldName = parameter.name.lCamelCase().javaEscape()
            if (!parameter.inherited || id == null) {
                // Null-id is superclass
                val fieldBuilder = FieldSpec.builder(fieldType, fieldName, Modifier.PROTECTED)
                //if (!fieldTlType.serializable())
                //fieldBuilder.addModifiers(Modifier.TRANSIENT)
                clazz.addField(fieldBuilder.build())
            }

            // Add serialize method entry if not a boolean present only to compute flag
            if (fieldTlType.serializable()) {
                serializeMethod.addCode(serializeParameter(fieldName, fieldTlType) + "\n")
                computeSizeMethod.addCode(computeSizeParameter(fieldName, fieldTlType) + "\n")
            }
            val deserializeStatement = "$fieldName = ${deserializeParameter(fieldTlType, fieldType)}"
            val count = deserializeStatement.split("\$T").size - 1
            if (count == 0)
                deserializeMethod.addStatement(deserializeStatement)
            else if (count == 1)
                deserializeMethod.addStatement(deserializeStatement, fieldType)
            else if (count == 2)
                deserializeMethod.addStatement(deserializeStatement, fieldType, fieldType)

            equalsStatements.add(equalsParameter(fieldName, fieldType))

            // Don't add if flags, since it'll be computed
            if (fieldTlType !is TLTypeFlag) {
                // Add set()/get()
                accessors.add(generateGetter(parameter.name, fieldName, fieldType))
                accessors.add(generateSetter(parameter.name, fieldName, fieldType))

                // Add constructor parameter
                constructorBuilder.addParameter(fieldType, fieldName)
                constructorBuilder.addStatement("this.$fieldName = $fieldName")

                // Add api method
                apiMethod?.addParameter(fieldType, fieldName)
                apiWrappedMethod?.addParameter(fieldType, fieldName)
                if (fieldTlType is TLTypeFunctional) {
                    apiMethod?.addTypeVariable(TypeVariableName.get("T", TYPE_TL_OBJECT))
                    apiWrappedMethod?.addTypeVariable(TypeVariableName.get("T", TYPE_TL_OBJECT))
                }
            }
        }

        computeSizeMethod.addStatement("return size")

        if (id != null) {
            if (parameters.isNotEmpty()) {
                clazz.addMethod(constructorBuilder.build())
                clazz.addMethod(serializeMethod.build())
                clazz.addMethod(deserializeMethod.build())
                clazz.addMethod(computeSizeMethod.build())
            }

            // _constructor
            clazz.addField(FieldSpec.builder(String::class.java, "_constructor")
                                   .addModifiers(Modifier.PRIVATE, Modifier.FINAL)
                                   .initializer("\$S", "$name#${hex(id)}")
                                   .build())

            // toString()
            clazz.addMethod(MethodSpec.methodBuilder("toString")
                                    .addAnnotation(Override::class.java)
                                    .addModifiers(Modifier.PUBLIC)
                                    .returns(String::class.java)
                                    .addStatement("return _constructor")
                                    .build())

            // getConstructorId
            clazz.addMethod(MethodSpec.methodBuilder("getConstructorId")
                                    .addAnnotation(Override::class.java)
                                    .addModifiers(Modifier.PUBLIC)
                                    .returns(TypeName.INT)
                                    .addStatement("return CONSTRUCTOR_ID")
                                    .build())

            if (equalsStatements.isEmpty()) equalsMethod.addStatement("return true")
            else equalsMethod.addStatement(equalsStatements.joinToString("\n&& ", prefix = "return "))
            //clazz.addMethod(equalsMethod.build())
        }
        clazz.addMethods(accessors)
    }

    private fun getType(type: TLType, boxedInTl: Boolean = false): TypeName = when (type) {
        is TLTypeFunctional -> ParameterizedTypeName.get(TYPE_TL_METHOD, TypeVariableName.get("T")) // ex: InitConnection
        is TLTypeAny -> TypeVariableName.get("T")
        is TLTypeFlag -> TypeName.INT
        is TLTypeConditional -> {
            val realTlType = getType(type.realType)
            if (type.realType !is TLTypeRaw || !arrayOf("true", "false", "Bool").contains(type.realType.name))
                realTlType.box()
            else realTlType
        }
        is TLTypeGeneric -> {
            when ((type.generics.first() as TLTypeRaw).name) {
                "int" -> TYPE_TL_INT_VECTOR
                "long" -> TYPE_TL_LONG_VECTOR
                "string" -> TYPE_TL_STRING_VECTOR
                else -> ParameterizedTypeName.get(TYPE_TL_VECTOR, getType(type.generics.first(), true).box())
            }
        }
        is TLTypeRaw -> {
            val name = type.name
            when (name) {
                "int" -> TypeName.INT
                "long" -> TypeName.LONG
                "double" -> TypeName.DOUBLE
                "float" -> TypeName.FLOAT
                "string" -> TypeName.get(String::class.java)
                "bytes" -> TYPE_TL_BYTES // TODO: wrap in bytes[], figure out offset/length
                "Bool", "true", "false" -> if (boxedInTl) TYPE_TL_BOOL else TypeName.BOOLEAN
                else -> typeClassNameMap[type] ?: throw RuntimeException("Unknown type $type")
            }
        }
        else -> throw RuntimeException("Unsupported type $type")
    }

    private fun serializeParameter(fieldName: String, fieldTlType: TLType): String = when (fieldTlType) {
        is TLTypeFunctional -> "writeTLMethod($fieldName, stream);"
        is TLTypeFlag -> "writeInt($fieldName, stream);"
        is TLTypeConditional -> {
            val statement = StringBuilder()
            statement.append("if ((flags & ${fieldTlType.pow2Value()}) != 0) {\n")
                    .append("    ")
            if (fieldTlType.realType !is TLTypeRaw || fieldTlType.realType.name != "Bool") {
                statement.append("""if ($fieldName == null) throwNullFieldException("$fieldName", flags);""").append('\n')
                        .append("    ")
            }
            statement.append(serializeParameter(fieldName, fieldTlType.realType)).append('\n')
                    .append('}')
            statement.toString()
        }
        is TLTypeGeneric -> "writeTLVector($fieldName, stream);"
        is TLTypeRaw -> when (fieldTlType.name) {
            "int" -> "writeInt($fieldName, stream);"
            "long" -> "writeLong($fieldName, stream);"
            "double" -> "writeDouble($fieldName, stream);"
            "float" -> "writeFloat($fieldName, stream);"
            "string" -> "writeString($fieldName, stream);"
            "bytes" -> "writeTLBytes($fieldName, stream);"
            "Bool" -> "writeBoolean($fieldName, stream);"
            "true", "false" -> ""
            else -> "writeTLObject($fieldName, stream);"
        }
        else -> throw RuntimeException("Unsupported type $fieldTlType")
    }

    private fun deserializeParameter(fieldTlType: TLType, fieldType: TypeName): String = when (fieldTlType) {
        is TLTypeFunctional -> "readTLMethod(stream, context)"
        is TLTypeFlag -> "readInt(stream)"
        is TLTypeConditional -> {
            val prefix = "(flags & ${fieldTlType.pow2Value()}) != 0"
            val realType = fieldTlType.realType
            val suffix = if (realType is TLTypeRaw && "Bool" == realType.name) "false" else "null"
            if (realType is TLTypeRaw && arrayOf("true", "false").contains(realType.name)) prefix
            else "$prefix ? ${deserializeParameter(realType, fieldType)} : $suffix"
        }
        is TLTypeGeneric -> when ((fieldTlType.generics.first() as TLTypeRaw).name) {
            "int" -> "readTLIntVector(stream, context)"
            "long" -> "readTLLongVector(stream, context)"
            "string" -> "readTLStringVector(stream, context)"
            else -> "readTLVector(stream, context)"
        }
        is TLTypeRaw -> when (fieldTlType.name) {
            "int" -> "readInt(stream)"
            "long" -> "readLong(stream)"
            "double" -> "readDouble(stream)"
            "float" -> "readFloat(stream)"
            "string" -> "readTLString(stream)"
            "bytes" -> "readTLBytes(stream, context)"
            "Bool" -> "readTLBool(stream)"
            else -> {
                val className = (fieldType as ClassName).simpleName()
                val isAbstract = className.startsWith("TLAbs", true)
                if (isAbstract) "readTLObject(stream, context, \$T.class, -1)"
                else "readTLObject(stream, context, \$T.class, \$T.CONSTRUCTOR_ID)"
            }
        }
        else -> throw RuntimeException("Unsupported type $fieldTlType")
    }

    private fun computeSizeParameter(fieldName: String, fieldTlType: TLType): String = when (fieldTlType) {
        is TLTypeFunctional -> "size += $fieldName.computeSerializedSize();"
        is TLTypeFlag -> "size += SIZE_INT32;"
        is TLTypeConditional -> {
            val statement = StringBuilder()
            statement.append("if ((flags & ${fieldTlType.pow2Value()}) != 0) {\n")
                    .append("    ")
            if (fieldTlType.realType !is TLTypeRaw || fieldTlType.realType.name != "Bool") {
                statement.append("""if ($fieldName == null) throwNullFieldException("$fieldName", flags);""").append('\n')
                        .append("    ")
            }
            statement.append(computeSizeParameter(fieldName, fieldTlType.realType)).append("\n")
                    .append('}')
            statement.toString()
        }
        is TLTypeGeneric -> "size += $fieldName.computeSerializedSize();"
        is TLTypeRaw -> {
            val name = fieldTlType.name
            when (name) {
                "int" -> "size += SIZE_INT32;"
                "long" -> "size += SIZE_INT64;"
                "double" -> "size += SIZE_DOUBLE;"
                "float" -> "size += SIZE_DOUBLE;"
                "string" -> "size += computeTLStringSerializedSize($fieldName);"
                "bytes" -> "size += computeTLBytesSerializedSize($fieldName);"
                "Bool" -> "size += SIZE_BOOLEAN;"
                else -> "size += $fieldName.computeSerializedSize();"
            }
        }
        else -> throw RuntimeException("Unsupported type $fieldTlType")
    }

    private fun equalsParameter(fieldName: String, fieldType: TypeName): String = when (fieldType) {
        TypeName.INT, TypeName.SHORT, TypeName.LONG, TypeName.FLOAT, TypeName.DOUBLE, TypeName.BOOLEAN, TypeName.CHAR -> "$fieldName == o.$fieldName"
        else -> "($fieldName == o.$fieldName || ($fieldName != null && o.$fieldName != null && $fieldName.equals(o.$fieldName)))"
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

    private fun methodName(typeName: String) = typeName.uCamelCase()
}