package com.github.badoualy.telegram.tl.builder.poet.utils

import com.github.badoualy.telegram.tl.builder.parser.TLAbstractConstructor
import com.github.badoualy.telegram.tl.builder.parser.TLMethod
import com.github.badoualy.telegram.tl.builder.parser.TLType
import com.github.badoualy.telegram.tl.builder.poet.PACKAGE_TL_API
import com.github.badoualy.telegram.tl.builder.poet.PACKAGE_TL_API_REQUEST
import com.github.badoualy.telegram.tl.builder.utils.uCamelCase
import com.github.badoualy.telegram.tl.builder.utils.uFirstLetter
import com.squareup.kotlinpoet.ClassName

fun TLType.packageName() = packageName(name, this is TLMethod)

fun TLType.typeName() = ClassName.get(packageName(), tlClassName())

fun TLType.tlClassName() = tlClassName(name,
                                       this is TLAbstractConstructor,
                                       this is TLMethod)

fun TLMethod.tlMethodName() = methodName(name)

// TODO: private?

fun methodName(typeName: String) = typeName.uCamelCase()

fun tlClassName(typeName: String, abstract: Boolean = false, request: Boolean = false) = when {
    abstract -> "TLAbs${typeName.split('.').last().uFirstLetter()}"
    request -> "TLRequest${typeName.uCamelCase()}"
    else -> "TL${typeName.split('.').last().uFirstLetter()}"
}

// TODO: replace with ext on TLType
fun packageName(typeName: String, isRequest: Boolean): String {
    var suffix = ""
    val subPackage = typeName.split('.').dropLast(1).joinToString(".")
    if (subPackage.isNotBlank()) suffix += ".$subPackage"
    return if (isRequest) PACKAGE_TL_API_REQUEST else PACKAGE_TL_API + suffix
}