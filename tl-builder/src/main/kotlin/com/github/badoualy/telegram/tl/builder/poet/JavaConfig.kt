package com.github.badoualy.telegram.tl.builder.poet

import com.github.badoualy.telegram.tl.builder.*
import com.github.badoualy.telegram.tl.builder.parser.TLCombinedTypeDef
import com.github.badoualy.telegram.tl.builder.parser.TLConstructorDef
import com.github.badoualy.telegram.tl.builder.parser.TLMethodDef
import com.github.badoualy.telegram.tl.builder.parser.TLParameterDef

var JavaCorePackage = "com.github.badoualy.telegram.tl.core"
var JavaPackage = "com.github.badoualy.telegram.tl.api"
var JavaMethodPackage = "requests"
var JavaClassPrefix = "TL"
var JavaAbstractClassPrefix = "Abs"
var JavaMethodClassPrefix = "Request"
var IgnoreUniting = arrayOf("DecryptedMessageAction")

fun mapJavaMethodName(methodDef: TLMethodDef): String {
    return methodDef.name.lCamelCase()
}

fun mapJavaMethodClassName(methodDef: TLMethodDef): String {
    return JavaClassPrefix + JavaMethodClassPrefix + methodDef.name.uCamelCase()
}

fun mapJavaPackage(typedef: TLCombinedTypeDef): String {
    var pkg = typedef.name.getNamespace()
    if (pkg == "") {
        return JavaPackage
    } else {
        return JavaPackage + "." + pkg
    }
}

fun mapJavaTypeName(typedef: TLCombinedTypeDef): String {
    return if (typedef.constructors.size == 1) {
        JavaClassPrefix + typedef.name.skipNamespace().uCamelCase()
    } else {
        JavaClassPrefix + JavaAbstractClassPrefix + typedef.name.skipNamespace().uCamelCase()
    }
}

fun mapJavaChildName(constructor: TLConstructorDef): String {
    return JavaClassPrefix + constructor.name.skipNamespace().uCamelCase()
}

fun mapVariableBaseName(parameter: TLParameterDef) = when (parameter.name) {
    "long" -> "lon"
    "private" -> "privat"
    "public" -> "publi"
    "final" -> "fina"
    else -> parameter.name.lCamelCase()
}