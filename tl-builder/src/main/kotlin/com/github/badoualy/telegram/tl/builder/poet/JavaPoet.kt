package com.github.badoualy.telegram.tl.builder.poet

//object JavaPoet {
//
//    private var tlDefinition = TLDefinition(emptyMap(), emptyList(), emptyList()) // Avoid to put it as nullable
//
//    val typeTypeNameMap = HashMap<TLType, ClassName>() // Map a type to it's ClassName to reference inside code
//    val constructorTypeNameMap = HashMap<TLConstructor, ClassName>() // Map a constructor to it's className to use when building context
//
//    val emptyConstructorAbstractedMap = HashMap<TLConstructor, Boolean>() // Map a constructor to true if it's abstracted for an "Empty" constructor only
//    val contextConstructors = ArrayList<TLConstructor>() // List of constructors to register in context
//    val testContext = ArrayList<ClassName>() // List of types for test context (contextConstructors + methods)
//
//    var totalClass = 0
//
//    val apiClazz = TypeSpec.interfaceBuilder(TELEGRAM_API_INTERFACE)
//            .addModifiers(Modifier.PUBLIC)
//            .addJavadoc(JAVADOC_AUTHOR).addJavadoc(JAVADOC_SEE)
//            .addAnnotation(AnnotationSpec.builder(SuppressWarnings::class.java).addMember("value", "{\"unused\", \"unchecked\", \"RedundantCast\"}").build())!!
//    var apiMethod: MethodSpec.Builder? = null
//
//    var apiWrappedClazz = TypeSpec.classBuilder(TELEGRAM_API_WRAPPER)
//            .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
//            .addJavadoc(JAVADOC_AUTHOR).addJavadoc(JAVADOC_SEE)
//            .addSuperinterface(TYPE_TELEGRAM_API)
//            .addAnnotation(AnnotationSpec.builder(SuppressWarnings::class.java).addMember("value", "{\"unused\", \"unchecked\", \"RedundantCast\"}").build())!!
//    var apiWrappedMethod: MethodSpec.Builder? = null
//
//    fun writeClasses(tlDefinition: TLDefinition) {
//        this.tlDefinition = tlDefinition
//        println("${tlDefinition.types.size} types")
//
//        println()
//        println("Generating constructors...")
//        writeConstructors()
//
//        println()
//        println("Generating methods...")
//        writeMethods()
//
//        println()
//        println("Generating context...")
//        writeContext()
//
//        println()
//        println("Generating test context...")
//        writeTestContext()
//
//        println()
//        println("Generated $totalClass classes")
//    }
//
//    private fun writeConstructors() {
//        // Build classes
//        nonAbstractedConstructors.forEach { constructor -> writeClassToFile(JavaPoet.packageName(constructor.name), generateConstructorClass(constructor)) }
//        abstractConstructors.forEach { constructor -> writeClassToFile(JavaPoet.packageName(constructor.name), generateAbstractConstructorClass(constructor)) }
//        abstractedConstructors.forEach { constructor -> writeClassToFile(JavaPoet.packageName(constructor.name), generateConstructorClass(constructor, typeTypeNameMap[constructor.tlType]!!)) }
//    }
//
//    private fun writeMethods() {
//        val methods = tlDefinition.methods.sorted()
//        totalClass += methods.size
//        println("${methods.size} methods related classes")
//
//        apiWrappedClazz.addMethod(MethodSpec.methodBuilder("executeRpcQuery")
//                                          .addException(TYPE_RPC_EXCEPTION).addException(IOException::class.java)
//                                          .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
//                                          .addTypeVariable(TypeVariableName.get("T", TYPE_TL_OBJECT))
//                                          .returns(TypeVariableName.get("T"))
//                                          .addParameter(ParameterizedTypeName.get(TYPE_TL_METHOD, TypeVariableName.get("T")), "method")
//                                          .build())
//
//        methods.forEach { method -> writeClassToFile(PACKAGE_TL_API_REQUEST, generateMethodClass(method)) }
//
//        writeClassToFile(PACKAGE_TL_API, apiClazz.build(), OUTPUT)
//        writeClassToFile(PACKAGE_TL_API, apiWrappedClazz.build(), OUTPUT)
//        totalClass += 2
//    }
//
//    private fun writeContext() {
//        val contextClazz = TypeSpec.classBuilder(TL_API_CONTEXT)
//                .addModifiers(Modifier.PUBLIC)
//                .addJavadoc(JAVADOC_AUTHOR)
//                .addJavadoc(JAVADOC_SEE)
//                .addAnnotation(AnnotationSpec.builder(SuppressWarnings::class.java).addMember("value", "\"unused\"").build())
//                .superclass(TYPE_TL_CONTEXT)
//
//        contextClazz.addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC).addStatement("super(\$L)", contextConstructors.size).build())
//
//        contextClazz.addField(TYPE_TL_API_CONTEXT, "instance", Modifier.PRIVATE, Modifier.STATIC)
//
//        contextClazz.addMethod(MethodSpec.methodBuilder("getInstance")
//                                       .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
//                                       .returns(TYPE_TL_API_CONTEXT)
//                                       .beginControlFlow("if (instance == null)")
//                                       .addStatement("instance = new \$T()", TYPE_TL_API_CONTEXT)
//                                       .endControlFlow()
//                                       .addStatement("return instance")
//                                       .build())
//
//        val methodBuilder = MethodSpec.methodBuilder("init").addModifiers(Modifier.PUBLIC).addAnnotation(Override::class.java)
//        for (constructor in contextConstructors.sorted()) {
//            val clazzName = constructorTypeNameMap[constructor]!!
//            methodBuilder.addStatement("registerClass(\$T.CONSTRUCTOR_ID, \$T.class" + ")", clazzName, clazzName)
//        }
//        contextClazz.addMethod(methodBuilder.build())
//
//        writeClassToFile(PACKAGE_TL_API, contextClazz.build())
//        totalClass++
//    }
//
//
//    private fun writeTestContext() {
//        val contextClazz = TypeSpec.classBuilder(TL_API_TEST_CONTEXT)
//                .addModifiers(Modifier.PUBLIC)
//                .addJavadoc(JAVADOC_AUTHOR)
//                .addJavadoc(JAVADOC_SEE)
//                .addAnnotation(AnnotationSpec.builder(SuppressWarnings::class.java).addMember("value", "\"unused\"").build())
//                .superclass(TYPE_TL_CONTEXT)
//
//        contextClazz.addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC).addStatement("super(\$L)", testContext.size).build())
//
//        contextClazz.addField(TYPE_TL_API_TEST_CONTEXT, "instance", Modifier.PRIVATE, Modifier.STATIC)
//
//        contextClazz.addMethod(MethodSpec.methodBuilder("getInstance")
//                                       .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
//                                       .returns(TYPE_TL_API_TEST_CONTEXT)
//                                       .beginControlFlow("if (instance == null)")
//                                       .addStatement("instance = new \$T()", TYPE_TL_API_TEST_CONTEXT)
//                                       .endControlFlow()
//                                       .addStatement("return instance")
//                                       .build())
//
//        val methodBuilder = MethodSpec.methodBuilder("init").addModifiers(Modifier.PUBLIC).addAnnotation(Override::class.java)
//        for (clazzType in testContext.sortedBy { it.simpleName() }) {
//            methodBuilder.addStatement("registerClass(\$T.CONSTRUCTOR_ID, \$T.class" + ")", clazzType, clazzType)
//        }
//        contextClazz.addMethod(methodBuilder.build())
//
//        writeClassToFile(PACKAGE_TL_API, contextClazz.build(), OUTPUT_TEST)
//        totalClass++
//    }
//
//    private fun generateConstructorClass(constructor: TLConstructor, superclass: ClassName = TYPE_TL_OBJECT): TypeSpec {
//        val clazz = TypeSpec.classBuilder(className(constructor.name))
//                .addModifiers(Modifier.PUBLIC)
//                .superclass(superclass)
//        val clazzTypeName = constructorTypeNameMap[constructor]!!
//
//        generateClassCommon(clazz, clazzTypeName, constructor.name, constructor.id, constructor.parameters)
//
//        if (emptyConstructorAbstractedMap.getOrDefault(constructor, false)) {
//            clazz.addMethod(MethodSpec.methodBuilder("isEmpty")
//                                    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
//                                    .addAnnotation(Override::class.java)
//                                    .returns(TypeName.BOOLEAN)
//                                    .addStatement("return \$L", constructor.name.endsWith("empty", true))
//                                    .build())
//
//            clazz.addMethod(MethodSpec.methodBuilder("isNotEmpty")
//                                    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
//                                    .addAnnotation(Override::class.java)
//                                    .returns(TypeName.BOOLEAN)
//                                    .addStatement("return \$L", !constructor.name.endsWith("empty", true))
//                                    .build())
//
//            if (!constructor.name.endsWith("empty", true)) {
//                clazz.addMethod(MethodSpec.methodBuilder("getAs" + constructor.name.split(".").last().uCamelCase())
//                                        .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
//                                        .addAnnotation(Override::class.java)
//                                        .returns(clazzTypeName)
//                                        .addStatement("return this")
//                                        .build())
//            }
//        }
//
//        return clazz
//                .addJavadoc(JAVADOC_AUTHOR)
//                .addJavadoc(JAVADOC_SEE)
//                .build()
//    }
//
//    private fun generateMethodClass(method: TLMethod): TypeSpec {
//        val clazzName = className(method.name, request = true)
//        val responseType = getType(method.tlType, true)
//        val clazzTypeName = ClassName.get(PACKAGE_TL_API_REQUEST, clazzName)
//        val clazz = TypeSpec.classBuilder(clazzName)
//                .addModifiers(Modifier.PUBLIC)
//                .addJavadoc(JAVADOC_AUTHOR)
//                .addJavadoc(JAVADOC_SEE)
//                .superclass(ParameterizedTypeName.get(TYPE_TL_METHOD, responseType))
//
//        val deserializeResponseMethod = MethodSpec.methodBuilder("deserializeResponse")
//                .addModifiers(Modifier.PUBLIC)
//                .addAnnotation(Override::class.java)
//                .addAnnotation(AnnotationSpec.builder(SuppressWarnings::class.java).addMember("value", """{"unchecked", "SimplifiableConditionalExpression"}""").build())
//                .addParameter(InputStream::class.java, "stream")
//                .addParameter(TYPE_TL_CONTEXT, "context")
//                .addException(IOException::class.java)
//                .returns(responseType)
//        if (method.tlType is TLTypeAny) {
//            clazz.addTypeVariable(TypeVariableName.get("T", TYPE_TL_OBJECT))
//
//            // Delegate
//            deserializeResponseMethod.addStatement("return query.deserializeResponse(stream, context)", TypeVariableName.get("T"))
//        } else if (method.tlType is TLTypeGeneric) {
//            when (responseType) {
//                TYPE_TL_INT_VECTOR -> deserializeResponseMethod.addStatement("return readTLIntVector(stream, context)")
//                TYPE_TL_LONG_VECTOR -> deserializeResponseMethod.addStatement("return readTLLongVector(stream, context)")
//                TYPE_TL_STRING_VECTOR -> deserializeResponseMethod.addStatement("return readTLStringVector(stream, context)")
//                else -> deserializeResponseMethod.addStatement("return readTLVector(stream, context)")
//            }
//        } else {
//            deserializeResponseMethod.addStatement("final \$T response = readTLObject(stream, context)", TYPE_TL_OBJECT)
//                    .beginControlFlow("if (response == null)")
//                    .addStatement("throw new \$T(\"Unable to parse response\")", IOException::class.java)
//                    .endControlFlow()
//
//                    .beginControlFlow("if (!(response instanceof \$T))", if (responseType is ParameterizedTypeName) responseType.rawType else responseType)
//                    .addStatement("throw new \$T(\"Incorrect response type, expected \" + getClass().getCanonicalName() + \", found \" + response.getClass().getCanonicalName())", IOException::class.java)
//                    .endControlFlow()
//
//                    .addStatement("return (\$T) response", responseType)
//        }
//        clazz.addMethod(deserializeResponseMethod.build())
//
//        apiMethod = MethodSpec.methodBuilder(method.name.lCamelCase())
//                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
//                .addException(TYPE_RPC_EXCEPTION).addException(IOException::class.java)
//                .returns(responseType)
//        apiWrappedMethod = MethodSpec.methodBuilder(method.name.lCamelCase())
//                .addModifiers(Modifier.PUBLIC).addAnnotation(Override::class.java)
//                .addException(TYPE_RPC_EXCEPTION).addException(IOException::class.java)
//                .returns(responseType)
//                .addStatement("return (\$T) executeRpcQuery(new \$T(\$L))",
//                              responseType,
//                              clazzTypeName,
//                              if (method.parameters.isNotEmpty())
//                                  method.parameters.filterNot { it.tlType is TLTypeFlag }.map { it.name.lCamelCase().javaEscape() }.joinToString(", ")
//                              else "")
//        generateClassCommon(clazz, clazzTypeName, method.name, method.id, method.parameters)
//        apiClazz.addMethod(apiMethod?.build())
//        apiWrappedClazz.addMethod(apiWrappedMethod?.build())
//        apiMethod = null
//        apiWrappedMethod = null
//
//        return clazz.build()
//    }
//

//
//    private fun serializeParameter(fieldName: String, fieldTlType: TLType): String = when (fieldTlType) {
//        is TLTypeFunctional -> "writeTLMethod($fieldName, stream);"
//        is TLTypeFlag -> "writeInt($fieldName, stream);"
//        is TLTypeConditional -> {
//            val statement = StringBuilder()
//            statement.append("if ((flags & ${fieldTlType.pow2Value()}) != 0) {\n")
//                    .append("    ")
//            if (fieldTlType.realType !is TLTypeRaw || fieldTlType.realType.name != "Bool") {
//                statement.append("""if ($fieldName == null) throwNullFieldException("$fieldName", flags);""").append('\n')
//                        .append("    ")
//            }
//            statement.append(serializeParameter(fieldName, fieldTlType.realType)).append('\n')
//                    .append('}')
//            statement.toString()
//        }
//        is TLTypeGeneric -> "writeTLVector($fieldName, stream);"
//        is TLTypeRaw -> when (fieldTlType.name) {
//            "int" -> "writeInt($fieldName, stream);"
//            "long" -> "writeLong($fieldName, stream);"
//            "double" -> "writeDouble($fieldName, stream);"
//            "float" -> "writeFloat($fieldName, stream);"
//            "string" -> "writeString($fieldName, stream);"
//            "bytes" -> "writeTLBytes($fieldName, stream);"
//            "Bool" -> "writeBoolean($fieldName, stream);"
//            "true", "false" -> ""
//            else -> "writeTLObject($fieldName, stream);"
//        }
//        else -> throw RuntimeException("Unsupported type $fieldTlType")
//    }
//
//    private fun deserializeParameter(fieldTlType: TLType, fieldType: TypeName): String = when (fieldTlType) {
//        is TLTypeFunctional -> "readTLMethod(stream, context)"
//        is TLTypeFlag -> "readInt(stream)"
//        is TLTypeConditional -> {
//            val prefix = "(flags & ${fieldTlType.pow2Value()}) != 0"
//            val realType = fieldTlType.realType
//            val suffix = if (realType is TLTypeRaw && "Bool" == realType.name) "false" else "null"
//            if (realType is TLTypeRaw && arrayOf("true", "false").contains(realType.name)) prefix
//            else "$prefix ? ${deserializeParameter(realType, fieldType)} : $suffix"
//        }
//        is TLTypeGeneric -> when ((fieldTlType.parameters.first() as TLTypeRaw).name) {
//            "int" -> "readTLIntVector(stream, context)"
//            "long" -> "readTLLongVector(stream, context)"
//            "string" -> "readTLStringVector(stream, context)"
//            else -> "readTLVector(stream, context)"
//        }
//        is TLTypeRaw -> when (fieldTlType.name) {
//            "int" -> "readInt(stream)"
//            "long" -> "readLong(stream)"
//            "double" -> "readDouble(stream)"
//            "float" -> "readFloat(stream)"
//            "string" -> "readTLString(stream)"
//            "bytes" -> "readTLBytes(stream, context)"
//            "Bool" -> "readTLBool(stream)"
//            else -> {
//                val className = (fieldType as ClassName).simpleName()
//                val isAbstract = className.startsWith("TLAbs", true)
//                if (isAbstract) "readTLObject(stream, context, \$T.class, -1)"
//                else "readTLObject(stream, context, \$T.class, \$T.CONSTRUCTOR_ID)"
//            }
//        }
//        else -> throw RuntimeException("Unsupported type $fieldTlType")
//    }
//
//    private fun computeSizeParameter(fieldName: String, fieldTlType: TLType): String = when (fieldTlType) {
//        is TLTypeFunctional -> "size += $fieldName.computeSerializedSize();"
//        is TLTypeFlag -> "size += SIZE_INT32;"
//        is TLTypeConditional -> {
//            val statement = StringBuilder()
//            statement.append("if ((flags & ${fieldTlType.pow2Value()}) != 0) {\n")
//                    .append("    ")
//            if (fieldTlType.realType !is TLTypeRaw || fieldTlType.realType.name != "Bool") {
//                statement.append("""if ($fieldName == null) throwNullFieldException("$fieldName", flags);""").append('\n')
//                        .append("    ")
//            }
//            statement.append(computeSizeParameter(fieldName, fieldTlType.realType)).append("\n")
//                    .append('}')
//            statement.toString()
//        }
//        is TLTypeGeneric -> "size += $fieldName.computeSerializedSize();"
//        is TLTypeRaw -> {
//            val name = fieldTlType.name
//            when (name) {
//                "int" -> "size += SIZE_INT32;"
//                "long" -> "size += SIZE_INT64;"
//                "double" -> "size += SIZE_DOUBLE;"
//                "float" -> "size += SIZE_DOUBLE;"
//                "string" -> "size += computeTLStringSerializedSize($fieldName);"
//                "bytes" -> "size += computeTLBytesSerializedSize($fieldName);"
//                "Bool" -> "size += SIZE_BOOLEAN;"
//                else -> "size += $fieldName.computeSerializedSize();"
//            }
//        }
//        else -> throw RuntimeException("Unsupported type $fieldTlType")
//    }
//
//    private fun equalsParameter(fieldName: String, fieldType: TypeName): String = when (fieldType) {
//        TypeName.INT, TypeName.SHORT, TypeName.LONG, TypeName.FLOAT, TypeName.DOUBLE, TypeName.BOOLEAN, TypeName.CHAR -> "$fieldName == o.$fieldName"
//        else -> "($fieldName == o.$fieldName || ($fieldName != null && o.$fieldName != null && $fieldName.equals(o.$fieldName)))"
//    }
//}