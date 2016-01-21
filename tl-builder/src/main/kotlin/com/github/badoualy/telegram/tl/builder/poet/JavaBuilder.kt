package com.github.badoualy.telegram.tl.builder.poet

import com.github.badoualy.telegram.tl.builder.parser.*
import java.io.File
import java.util.*

fun convertToJavaModel(model: TLModel): JavaModel {
    var javaTypes = HashMap<String, JavaTypeObject>()
    model.types.filterIsInstance(TLCombinedTypeDef::class.java).forEach { t -> javaTypes.put(t.name, JavaTypeObject(t)) }

    val javaMethods = model.methods.map { m -> JavaRpcMethod(m) }

    for (t in javaTypes.values) {
        for (p in t.commonParameters) {
            p.reference = mapReference(javaTypes, p.tlParameterDef.typeDef)
        }
        for (c in t.constructors) {
            for (p in c.parameters) {
                p.reference = mapReference(javaTypes, p.tlParameterDef.typeDef)
            }
        }
    }

    for (m in javaMethods) {
        m.returnReference = mapReference(javaTypes, m.tlMethod.returnType)

        for (p in m.parameters) {
            p.reference = mapReference(javaTypes, p.tlParameterDef.typeDef)
        }
    }

    return JavaModel(javaTypes, javaMethods)
}

fun mapReference(javaTypes: HashMap<String, JavaTypeObject>, tlType: TLTypeDef): JavaTypeReference = when (tlType) {
    is TLCombinedTypeDef -> JavaTypeTlReference(tlType, javaTypes[tlType.name]!!)
    is TLBuiltInTypeDef ->
        JavaTypeBuiltInReference(tlType)
    is TLBuiltInGenericTypeDef -> {
        var generic = tlType
        if (generic.name != "Vector") {
            throw RuntimeException("Only Vector built-in generics are supported")
        }
        JavaTypeVectorReference(tlType, mapReference(javaTypes, tlType.basic))
    }
    is TLBuiltInTypeDef -> JavaTypeBuiltInReference(tlType)
    is TLAnyTypeDef -> JavaTypeAnyReference(tlType)
    is TLFunctionalTypeDef -> JavaTypeFunctionalReference(tlType)
    is TLFlagTypeDef -> JavaTypeFlagReference(tlType)
    else -> JavaTypeUnknownReference(tlType)
}

fun buildSerializer(parameters: List<JavaParameter>): String {
    if (parameters.size == 0) return ""

    var serializer = ""
    val hasFlags = parameters.any { p -> p.tlParameterDef.flagInfo != null }
    if (hasFlags) {
        // Compile flag

        for (parameter in parameters.filter { p -> p.tlParameterDef.flagInfo != null }) {
            val flagInfo = parameter.tlParameterDef.flagInfo!!
            if (arrayOf("true", "false").contains(flagInfo.realTypeName))
                serializer += JavaSerializeFlagCompile
                        .replace("{int}", parameter.internalName)
                        .replace("{mask}", flagInfo.value.toString())
        }
    }

    for (parameter in parameters) {
        val flagValue = parameter.tlParameterDef.flagInfo
        var content = serializeParameter(parameter)
        if (flagValue != null) {
            serializer += JavaSerializeConditional.replace("{int}", flagValue.value.toString())
            content = content.replaceFirst("\n", "\n    ")
        }
        serializer += content;
    }

    return JavaSerializeTemplate.replace("{body}", serializer)
}

fun serializeParameter(p: JavaParameter): String = when (p.reference) {
    is JavaTypeTlReference -> JavaSerializeObject.replace("{int}", p.internalName)
    is JavaTypeVectorReference -> JavaSerializeVector.replace("{int}", p.internalName)
    is JavaTypeBuiltInReference -> when (p.tlParameterDef.typeDef.name) {
        "int" -> JavaSerializeInt.replace("{int}", p.internalName)
        "Bool" -> JavaSerializeBoolean.replace("{int}", p.internalName)
        "long" -> JavaSerializeLong.replace("{int}", p.internalName)
        "double" -> JavaSerializeDouble.replace("{int}", p.internalName)
        "string" -> JavaSerializeString.replace("{int}", p.internalName)
        "bytes" -> JavaSerializeBytes.replace("{int}", p.internalName)
        else -> throw RuntimeException("Unknown internal type: ${p.tlParameterDef.typeDef.name}")
    }
    is JavaTypeFunctionalReference -> JavaSerializeFunctional.replace("{int}", p.internalName)
    is JavaTypeAnyReference -> JavaSerializeObject.replace("{int}", p.internalName)
    is JavaTypeFlagReference -> JavaSerializeFlag.replace("{int}", p.internalName)
    else -> throw RuntimeException("Unknown type: " + p.tlParameterDef.typeDef)
}

fun buildDeserializer(parameters: List<JavaParameter>): String {
    if (parameters.isEmpty()) return ""

    val serializeMethodContent = parameters.map { p -> deserializeParameter(p) }.joinToString("")
    return JavaDeserializeTemplate.replace("{body}", serializeMethodContent)
}

fun deserializeParameter(p: JavaParameter): String {
    val flagInfo = p.tlParameterDef.flagInfo

    var header = ""
    if (flagInfo != null) {
        header = JavaDeserializeConditional.replace("{int}", flagInfo.value.toString())
    }

    var serializer = ""
    if (p.reference is JavaTypeTlReference) {
        serializer += JavaDeserializeObject.replace("{int}", p.internalName)
                .replace("{type}", (p.reference as JavaTypeTlReference).javaName)
    } else if (p.reference is JavaTypeVectorReference) {
        if ((p.reference as JavaTypeVectorReference).internalReference is JavaTypeBuiltInReference) {
            var intReference = (p.reference as JavaTypeVectorReference).internalReference as JavaTypeBuiltInReference
            if (intReference.javaName == "int") {
                serializer += JavaDeserializeIntVector.replace("{int}", p.internalName)
            } else if (intReference.javaName == "long") {
                serializer += JavaDeserializeLongVector.replace("{int}", p.internalName)
            } else if (intReference.javaName == "String") {
                serializer += JavaDeserializeStringVector.replace("{int}", p.internalName)
            } else {
                serializer += JavaDeserializeVector.replace("{int}", p.internalName)
            }
        } else {
            serializer += JavaDeserializeVector.replace("{int}", p.internalName)
        }
    } else if (p.reference is JavaTypeBuiltInReference) {
        if (p.tlParameterDef.typeDef.name == "int") {
            serializer += JavaDeserializeInt.replace("{int}", p.internalName)
        } else if (p.tlParameterDef.typeDef.name == "Bool") {
            serializer += JavaDeserializeBoolean.replace("{int}", p.internalName)
        } else if (p.tlParameterDef.typeDef.name == "long") {
            serializer += JavaDeserializeLong.replace("{int}", p.internalName)
        } else if (p.tlParameterDef.typeDef.name == "double") {
            serializer += JavaDeserializeDouble.replace("{int}", p.internalName)
        } else if (p.tlParameterDef.typeDef.name == "string") {
            serializer += JavaDeserializeString.replace("{int}", p.internalName)
        } else if (p.tlParameterDef.typeDef.name == "bytes") {
            serializer += JavaDeserializeBytes.replace("{int}", p.internalName)
        } else throw RuntimeException("Unknown internal type: " + p.tlParameterDef.typeDef.name)
    } else if (p.reference is JavaTypeFunctionalReference) {
        serializer += JavaDeserializeFunctional.replace("{int}", p.internalName)
    } else if (p.reference is JavaTypeAnyReference) {
        serializer += JavaDeserializeObject.replace("{int}", p.internalName)
                .replace("{type}", "TLObject")
    } else if (p.reference is JavaTypeFlagReference) {
        serializer += JavaDeserializeFlag.replace("{int}", p.internalName)
    } else {
        throw RuntimeException("Unknown type: " + p.tlParameterDef.typeDef)
    }

    var footer = ""
    if (flagInfo != null) {
        if (flagInfo.realTypeName == "true" || flagInfo.realTypeName == "false") {
            header = ""
            footer = ""

            serializer = if (flagInfo.realTypeName == "true")
                JavaDeserializeConditionalBoolTrue
            else
                JavaDeserializeConditionalBoolFalse

            serializer = serializer.replace("{int}", p.internalName).replace("{mask}", flagInfo.value.toString())
        } else {
            serializer = serializer.replaceFirst("\n", "\n    ")
        }
    }

    return header + serializer + footer
}

fun writeJavaClasses(model: JavaModel, path: String) {
    for (t in model.types.values) {
        if (t.constructors.size == 1 && !IgnoreUniting.any { x -> x == t.tlType.name }) {
            var generatedFile = JavaClassTemplate
            generatedFile = generatedFile
                    .replace("{name}", t.javaTypeName)
                    .replace("{package}", t.javaPackage)
                    .replace("{class_id}", "0x" + Integer.toHexString(t.constructors.first().tlConstructor.id))
                    .replace("{to_string}",
                            JavaToStringTemplate.replace("{value}", t.constructors.first().tlConstructor.name + "#" + Integer.toHexString(t.constructors.first().tlConstructor.id)))

            var fields = ""
            for (p in t.constructors[0].parameters) {
                fields += JavaFieldTemplate
                        .replace("{type}", p.reference!!.javaName)
                        .replace("{int}", p.internalName)
            }
            generatedFile = generatedFile.replace("{fields}", fields)

            var getterSetter = ""
            for (p in t.constructors[0].parameters) {
                getterSetter += JavaGetterSetterTemplate
                        .replace("{type}", p.reference!!.javaName)
                        .replace("{int}", p.internalName)
                        .replace("{getter}", p.getterName)
                        .replace("{setter}", p.setterName)
            }

            if (t.constructors[0].parameters.size > 0) {
                var constructorArgs = ""
                var constructorBody = ""
                for (p in t.constructors[0].parameters) {
                    if (constructorArgs != "") {
                        constructorArgs += ", "
                    }

                    constructorArgs += JavaConstructorArgTemplate
                            .replace("{type}", p.reference!!.javaName)
                            .replace("{int}", p.internalName)

                    constructorBody += JavaConstructorBodyTemplate
                            .replace("{type}", p.reference!!.javaName)
                            .replace("{int}", p.internalName) + "\n"
                }
                generatedFile = generatedFile.replace("{constructor}",
                        JavaConstructorTemplate
                                .replace("{name}", t.javaTypeName)
                                .replace("{args}", constructorArgs)
                                .replace("{body}", constructorBody))
            } else {
                generatedFile = generatedFile.replace("{constructor}", "")
            }

            generatedFile = generatedFile.replace("{getter-setters}", getterSetter)

            generatedFile = generatedFile.replace("{serialize}", buildSerializer(t.constructors[0].parameters))
            generatedFile = generatedFile.replace("{deserialize}", buildDeserializer(t.constructors[0].parameters))

            var directory = t.javaPackage.split('.').fold(path, { x, y -> x + "/" + y })
            val destFile = File(directory + "/" + t.javaTypeName + ".java")
            File(directory).mkdirs()
            destFile.writeText(generatedFile, "utf-8")
        } else {
            var directory = t.javaPackage.split('.').fold(path, { x, y -> x + "/" + y })
            run {
                var generatedFile = JavaAbsClassTemplate
                generatedFile = generatedFile
                        .replace("{name}", t.javaTypeName)
                        .replace("{package}", t.javaPackage)
                var fields = ""
                for (p in t.commonParameters) {
                    fields += JavaFieldTemplate
                            .replace("{type}", p.reference!!.javaName)
                            .replace("{int}", p.internalName)
                }
                generatedFile = generatedFile.replace("{fields}", fields)

                var getterSetter = ""
                for (p in t.commonParameters) {
                    getterSetter += JavaGetterSetterTemplate
                            .replace("{type}", p.reference!!.javaName)
                            .replace("{int}", p.internalName)
                            .replace("{getter}", p.getterName)
                            .replace("{setter}", p.setterName)
                }

                generatedFile = generatedFile.replace("{getter-setters}", getterSetter)

                val destFile = File(directory + "/" + t.javaTypeName + ".java")
                File(directory).mkdirs()
                destFile.writeText(generatedFile, "utf-8")
            }

            for (constr in t.constructors) {
                var generatedFile = JavaChildClassTemplate
                generatedFile = generatedFile
                        .replace("{name}", constr.javaClassName)
                        .replace("{base-name}", t.javaTypeName)
                        .replace("{package}", t.javaPackage)
                        .replace("{class_id}", "0x" + Integer.toHexString(constr.tlConstructor.id))
                        .replace("{to_string}",
                                JavaToStringTemplate.replace("{value}", constr.tlConstructor.name + "#" + Integer.toHexString(constr.tlConstructor.id)))
                var fields = ""
                for (p in constr.parameters) {
                    if (t.commonParameters.any { x -> x.internalName == p.internalName }) {
                        continue
                    }
                    fields += JavaFieldTemplate
                            .replace("{type}", p.reference!!.javaName)
                            .replace("{int}", p.internalName)
                }
                generatedFile = generatedFile.replace("{fields}", fields)

                var getterSetter = ""
                for (p in constr.parameters) {
                    if (t.commonParameters.any { x -> x.internalName == p.internalName }) {
                        continue
                    }
                    getterSetter += JavaGetterSetterTemplate
                            .replace("{type}", p.reference!!.javaName)
                            .replace("{int}", p.internalName)
                            .replace("{getter}", p.getterName)
                            .replace("{setter}", p.setterName)
                }

                if (constr.parameters.size > 0) {
                    var constructorArgs = ""
                    var constructorBody = ""
                    for (p in constr.parameters) {
                        if (constructorArgs != "") {
                            constructorArgs += ", "
                        }

                        constructorArgs += JavaConstructorArgTemplate
                                .replace("{type}", p.reference!!.javaName)
                                .replace("{int}", p.internalName)

                        constructorBody += JavaConstructorBodyTemplate
                                .replace("{type}", p.reference!!.javaName)
                                .replace("{int}", p.internalName) + "\n"
                    }
                    var constructor = JavaConstructorTemplate
                            .replace("{name}", constr.javaClassName)
                            .replace("{args}", constructorArgs)
                            .replace("{body}", constructorBody)
                    generatedFile = generatedFile.replace("{constructor}", constructor)
                } else {
                    generatedFile = generatedFile.replace("{constructor}", "")
                }

                generatedFile = generatedFile.replace("{getter-setters}", getterSetter)

                generatedFile = generatedFile.replace("{serialize}", buildSerializer(constr.parameters))
                generatedFile = generatedFile.replace("{deserialize}", buildDeserializer(constr.parameters))

                val destFile = File(directory + "/" + constr.javaClassName + ".java")
                File(directory).mkdirs()
                destFile.writeText(generatedFile, "utf-8")
            }
        }
    }

    for (m in model.methods) {

        val isInvokeWithLayer = m.methodName.contains("invokeWithLayer", true)
        val isInitConnection = m.methodName.contains("initConnection", true)
        if (isInvokeWithLayer || isInitConnection) {
            m.requestClassName += "<T extends TLObject>"
            m.returnReference = JavaTypeMethodReference(m.returnReference?.tlReference ?: TLAnyTypeDef())

            for (param in m.parameters) {
                if (param.internalName.equals("query")) {
                    param.reference?.javaName = param.reference?.javaName?.concat("<T>")
                }
            }
        }

        var generatedFile = JavaMethodTemplate
        var returnTypeName = m.returnReference!!.javaName
        if (returnTypeName == "boolean") {
            returnTypeName = "TLBool"
        }
        generatedFile = generatedFile
                .replace("{name}", m.requestClassName)
                .replace("{package}", JavaPackage + "." + JavaMethodPackage)
                .replace("{class_id}", "0x" + Integer.toHexString(m.tlMethod.id))
                .replace("{return_type}", returnTypeName)
                .replace("{to_string}",
                        JavaToStringTemplate.replace("{value}", m.tlMethod.name + "#" + Integer.toHexString(m.tlMethod.id)))

        var fields = ""
        for (p in m.parameters) {
            fields += JavaFieldTemplate
                    .replace("{type}", p.reference!!.javaName)
                    .replace("{int}", p.internalName)
        }
        generatedFile = generatedFile.replace("{fields}", fields)

        var getterSetter = ""
        for (p in m.parameters) {
            getterSetter += JavaGetterSetterTemplate
                    .replace("{type}", p.reference!!.javaName)
                    .replace("{int}", p.internalName)
                    .replace("{getter}", p.getterName)
                    .replace("{setter}", p.setterName)
        }

        if (m.parameters.size > 0) {
            var constructorArgs = ""
            var constructorBody = ""
            for (p in m.parameters) {
                if (constructorArgs != "") {
                    constructorArgs += ", "
                }

                constructorArgs += JavaConstructorArgTemplate
                        .replace("{type}", p.reference!!.javaName)
                        .replace("{int}", p.internalName)

                constructorBody += JavaConstructorBodyTemplate
                        .replace("{type}", p.reference!!.javaName)
                        .replace("{int}", p.internalName) + "\n"
            }
            var constructor = JavaConstructorTemplate
                    .replace("{name}", m.requestClassName.replace(Regex("<.*>"), ""))
                    .replace("{args}", constructorArgs)
                    .replace("{body}", constructorBody)
            generatedFile = generatedFile.replace("{constructor}", constructor)
        } else {
            var constructor = JavaConstructorTemplate
                    .replace("{name}", m.requestClassName)
                    .replace("{args}", "")
                    .replace("{body}", "")
            generatedFile = generatedFile.replace("{constructor}", constructor)
        }

        generatedFile = generatedFile.replace("{getter-setters}", getterSetter)

        generatedFile = generatedFile.replace("{serialize}", buildSerializer(m.parameters))
        generatedFile = generatedFile.replace("{deserialize}", buildDeserializer(m.parameters))


        var responseParser = JavaMethodParserTemplate.replace("{return_type}",
                returnTypeName)
        if (m.returnReference is JavaTypeVectorReference) {
            var vectorReference = m.returnReference as JavaTypeVectorReference
            if (vectorReference.internalReference is JavaTypeBuiltInReference) {
                var intReference = vectorReference.internalReference as JavaTypeBuiltInReference
                if (intReference.javaName == "int") {
                    responseParser = responseParser.replace("{body}", JavaMethodParserBodyIntVector)
                } else if (intReference.javaName == "long") {
                    responseParser = responseParser.replace("{body}", JavaMethodParserBodyLongVector)
                } else {
                    throw RuntimeException("Unsupported vector internal reference")
                }
            } else if (vectorReference.internalReference is JavaTypeTlReference) {
                var tlReference = vectorReference.internalReference as JavaTypeTlReference
                responseParser = responseParser.replace("{body}",
                        JavaMethodParserBodyVector.replace("{vector_type}", tlReference.javaName))
            } else {
                throw RuntimeException("Unsupported built-in reference")
            }
        } else if (m.returnReference is JavaTypeTlReference) {
            var returnReference = m.returnReference as JavaTypeTlReference
            responseParser = responseParser.replace("{body}",
                    JavaMethodParserBodyGeneral.replace("{return_type}", returnReference.javaName))
        } else if (m.returnReference is JavaTypeBuiltInReference) {
            var returnReference = m.returnReference as JavaTypeBuiltInReference
            if (returnReference.javaName != "boolean") {
                throw RuntimeException("Only boolean built-in reference allowed as return")
            }
            responseParser = responseParser.replace("{body}",
                    JavaMethodParserBodyGeneral.replace("{return_type}", "TLBool"))
        } else if (m.returnReference is JavaTypeMethodReference) {
            var functionalParameter: JavaParameter? = null
            for (p in m.parameters) {
                if (p.reference is JavaTypeFunctionalReference) {
                    functionalParameter = p
                    break
                }
            }

            responseParser = responseParser.replace("{body}",
                    JavaMethodParserBodyReference.replace("{return_type}", "T")
                            .replace("{int}", functionalParameter?.internalName ?: ""))
        } else {
            var functionalParameter: JavaParameter? = null
            for (p in m.parameters) {
                if (p.reference is JavaTypeFunctionalReference) {
                    functionalParameter = p
                    break
                }
            }

            if (functionalParameter == null) {
                throw RuntimeException("Any reference without functional reference: " + m.methodName)
            }

            // throw RuntimeException("Unsupported return reference")
            responseParser = responseParser.replace("{body}",
                    JavaMethodParserBodyReference.replace("{return_type}", "TLObject")
                            .replace("{int}", functionalParameter.internalName))
        }

        generatedFile = generatedFile.replace("{responseParser}", responseParser)

        var directory = (JavaPackage + "." + JavaMethodPackage).split('.').fold(path, { x, y -> x + "/" + y })
        val destFile = File(directory + "/" + m.requestClassName.replace(Regex("<.*>"), "") + ".java")
        File(directory).mkdirs()
        destFile.writeText(generatedFile, "utf-8")
    }

    var requestsReactive = ""
    var requestsPrototypeReactive = ""
    var requests = ""
    var requestsPrototype = ""

    for (m in model.methods) {

        var args = ""
        var methodArgs = ""
        for (p in m.parameters) {
            if (args != "") {
                args += ", "
            }
            if (methodArgs != "") {
                methodArgs += ", "
            }
            methodArgs += p.internalName
            args += p.reference!!.javaName + " " + p.internalName
        }

        var returnTypeName = m.returnReference!!.javaName
        if (returnTypeName == "boolean") {
            returnTypeName = "TLBool"
        }

        var reactiveReturnTypeName = "Observable<$returnTypeName>"
        if (returnTypeName.equals("T")) {
            returnTypeName = "<T extends TLObject> T"
            reactiveReturnTypeName = "<T extends TLObject> Observable<T>"
        }

        requestsReactive += JavaApiWrapperMethod.replace("{return_type}", reactiveReturnTypeName)
                .replace("{method_name}", m.methodName)
                .replace("{method_class}", m.requestClassName.replace(Regex("<.*>"), ""))
                .replace("{args}", args)
                .replace("{method_args}", methodArgs)

        requestsPrototypeReactive += JavaApiMethodPrototype.replace("{return_type}", reactiveReturnTypeName)
                .replace("{method_name}", m.methodName)
                .replace("{args}", args)

        requests += JavaApiWrapperMethod.replace("{return_type}", returnTypeName)
                .replace("{method_name}", m.methodName)
                .replace("{method_class}", m.requestClassName.replace(Regex("<.*>"), "<>"))
                .replace("{args}", args)
                .replace("{method_args}", methodArgs)

        requestsPrototype += JavaApiMethodPrototype.replace("{return_type}", returnTypeName)
                .replace("{method_name}", m.methodName)
                .replace("{args}", args)
    }

    var directory = JavaPackage.split('.').fold(path, { x, y -> x + "/" + y })
    val destReactiveApiWrapperFile = File(directory + "/TelegramReactiveApiWrapper.java")
    val destReactiveApiFile = File(directory + "/TelegramReactiveApi.java")
    val destApiWrapperFile = File(directory + "/TelegramApiWrapper.java")
    val destApiFile = File(directory + "/TelegramApi.java")
    File(directory).mkdirs()
    destReactiveApiWrapperFile.writeText(JavaReactiveApiWrapperTemplate
            .replace("{methods}", requestsReactive)
            .replace("{package}", JavaPackage), "utf-8")
    destReactiveApiFile.writeText(JavaReactiveApiTemplate
            .replace("{methods}", requestsPrototypeReactive)
            .replace("{package}", JavaPackage), "utf-8")
    destApiWrapperFile.writeText(JavaApiWrapperTemplate
            .replace("{methods}", requests)
            .replace("{package}", JavaPackage), "utf-8")
    destApiFile.writeText(JavaApiTemplate
            .replace("{methods}", requestsPrototype)
            .replace("{package}", JavaPackage), "utf-8")

    var contextInit = ""
    for (t in model.types.values) {
        if (t.constructors.size == 1 && !IgnoreUniting.any { x -> x == t.tlType.name }) {
            contextInit += JavaContextIntRecord
                    .replace("{type}", t.javaPackage + "." + t.javaTypeName)
                    .replace("{id}", "0x" + Integer.toHexString(t.constructors.first().tlConstructor.id))
        } else {
            for (c in t.constructors) {
                contextInit += JavaContextIntRecord
                        .replace("{type}", t.javaPackage + "." + c.javaClassName)
                        .replace("{id}", "0x" + Integer.toHexString(c.tlConstructor.id))
            }
        }
    }

    val destFile = File(directory + "/TLApiContext.java")
    File(directory).mkdirs()
    destFile.writeText(JavaContextTemplate
            .replace("{init}", contextInit)
            .replace("{package}", JavaPackage), "utf-8")
}