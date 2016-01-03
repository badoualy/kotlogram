package com.github.badoualy.telegram.tl.builder

import java.util.*

class JavaModel(var types: HashMap<String, JavaTypeObject>, var methods: List<JavaRpcMethod>)

class JavaTypeObject(var tlType: TLCombinedTypeDef) {
    public val javaPackage: String = mapJavaPackage(tlType)
    public val javaTypeName: String = mapJavaTypeName(tlType)
    public val constructors: List<JavaTypeConstructor> = tlType.constructors.map { x -> JavaTypeConstructor(x, this) };

    public val commonParameters: List<JavaParameter>

    init {
        var parameters = ArrayList<JavaParameter>()
        if (!IgnoreUniting.any { x -> x == tlType.name }) {
            var baseConstructor = constructors.first();
            outer@ for (p in baseConstructor.parameters) {
                var pName = p.tlParameterDef.name
                var pType = p.tlParameterDef.typeDef

                for (constr in constructors) {
                    var hasParameter = false
                    for (cP in constr.parameters) {
                        var areSameType = cP.tlParameterDef.typeDef == pType;
                        if (cP.tlParameterDef.name == pName && areSameType) {
                            hasParameter = true;
                            break;
                        }
                    }
                    if (!hasParameter) {
                        continue@outer
                    }
                }

                parameters.add(p)
            }
        }
        commonParameters = parameters
    }
}

class JavaTypeConstructor(var tlConstructor: TLConstructorDef, javaType: JavaTypeObject) {
    public val javaClassName: String = mapJavaChildName(tlConstructor);
    public val parameters: List<JavaParameter> = tlConstructor.parameters.map { x -> JavaParameter(x) }
}

abstract class JavaTypeReference(var tlReference: TLTypeDef, var javaName: String)

class JavaTypeTlReference(tlReference: TLTypeDef, var javaReference: JavaTypeObject) :
        JavaTypeReference(tlReference, javaReference.javaPackage + "." + javaReference.javaTypeName)

class JavaTypeFunctionalReference(tlReference: TLTypeDef) : JavaTypeReference(tlReference, "TLMethod")

class JavaTypeAnyReference(tlReference: TLTypeDef) : JavaTypeReference(tlReference, "TLObject")

class JavaTypeMethodReference(tlReference: TLTypeDef) : JavaTypeReference(tlReference, "T")

class JavaTypeUnknownReference(tlReference: TLTypeDef) : JavaTypeReference(tlReference, "???")

class JavaTypeVectorReference(tlReference: TLTypeDef, var internalReference: JavaTypeReference) :
        JavaTypeReference(tlReference,
                when (internalReference) {
                    is JavaTypeBuiltInReference -> {
                        when (internalReference.javaName) {
                            "int" -> JavaCorePackage + ".TLIntVector"
                            "long" -> JavaCorePackage + ".TLLongVector"
                            "String" -> JavaCorePackage + ".TLStringVector"
                            else -> throw RuntimeException("Unsupported built in reference in vector: " + internalReference.javaName)
                        }
                    }
                    is JavaTypeVectorReference -> JavaCorePackage + ".TLVector<" + internalReference.javaName + ">"
                    is JavaTypeTlReference -> JavaCorePackage + ".TLVector<" + internalReference.javaName + ">"
                    else -> throw RuntimeException("Unsupported reference in vector: " + internalReference.javaName)
                })

class JavaTypeBuiltInReference(tlReference: TLBuiltInTypeDef) : JavaTypeReference(tlReference, when (tlReference.name) {
    "int" -> "int"
    "long" -> "long"
    "double" -> "double"
    "string" -> "String"
    "bytes" -> "TLBytes"
    "Bool" -> "boolean"
    else -> throw RuntimeException("Unsupported built in reference: " + tlReference.name)
})

class JavaParameter(var tlParameterDef: TLParameterDef) {
    public val internalName: String = mapVariableBaseName(tlParameterDef)
    public val getterName: String = "get" + internalName.uCamelCase();
    public val setterName: String = "set" + internalName.uCamelCase();
    public var reference: JavaTypeReference? = null;
}

class JavaRpcMethod(var tlMethod: TLMethodDef) {
    public var methodName: String = mapJavaMethodName(tlMethod)
    public var requestClassName: String = mapJavaMethodClassName(tlMethod)
    public var returnReference: JavaTypeReference? = null;
    public val parameters: List<JavaParameter> = tlMethod.args.map { x -> JavaParameter(x) }
}