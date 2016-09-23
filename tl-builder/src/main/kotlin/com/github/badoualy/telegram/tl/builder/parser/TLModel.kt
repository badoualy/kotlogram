package com.github.badoualy.telegram.tl.builder.parser

import com.github.badoualy.telegram.tl.builder.hex
import java.util.*

// Main definition
class TLDefinition(val types: Map<String, TLType>, val constructors: List<TLConstructor>, val methods: List<TLMethod>)

// Types
abstract class TLType() {
    open fun serializable() = true
}

class TLTypeRaw(val name: String) : TLType() {
    override fun toString() = name
    override fun equals(other: Any?) = other is TLTypeRaw && other.name == name
    override fun hashCode() = toString().hashCode()
}

class TLTypeGeneric(val name: String, val generics: Array<TLType>) : TLType() {
    override fun toString() = "Generic<$name>"
    override fun equals(other: Any?) = other is TLTypeGeneric
    override fun hashCode() = toString().hashCode()
}

class TLTypeAny() : TLType() {
    override fun toString() = "#Any"
    override fun equals(other: Any?) = other is TLTypeAny
    override fun hashCode() = toString().hashCode()
}

class TLTypeFunctional() : TLType() {
    override fun toString() = "#Functional"
    override fun equals(other: Any?) = other is TLTypeFunctional
    override fun hashCode() = toString().hashCode()
}

class TLTypeFlag() : TLType() {
    override fun toString() = "#Flag"
    override fun equals(other: Any?) = other is TLTypeFlag
    override fun hashCode() = toString().hashCode()
}

class TLTypeConditional(val value: Int, val realType: TLType) : TLType() {
    fun pow2Value() = Math.pow(2.toDouble(), value.toDouble()).toInt()

    override fun serializable() = !(realType is TLTypeRaw && realType.name.equals("true", true))
    override fun toString() = "flag.$value?$realType"
    override fun equals(other: Any?) = other is TLTypeConditional && other.value == value && other.realType == realType
    override fun hashCode() = toString().hashCode()
}

// 1 Constructor = 1 class = 1 type
class TLConstructor(val name: String, val id: Int, val parameters: ArrayList<TLParameter>, val tlType: TLTypeRaw) : Comparable<TLConstructor> {
    override fun toString() = "$name#${hex(id)} -> $tlType"
    override fun compareTo(other: TLConstructor) = name.compareTo(other.name)
    override fun equals(other: Any?) = other is TLConstructor && other.name == name && other.id == id
    override fun hashCode() = toString().hashCode()
}

class TLAbstractConstructor(val name: String, val parameters: List<TLParameter>, val tlType: TLTypeRaw, val abstractEmptyConstructor: Boolean) : Comparable<TLAbstractConstructor> {
    override fun toString() = "$name -> $tlType"
    override fun compareTo(other: TLAbstractConstructor) = name.compareTo(other.name)
    override fun equals(other: Any?) = other is TLConstructor && other.name == name
    override fun hashCode() = toString().hashCode()
}

// Method: 1 method = 1 class = 1 rpc call "model class"
class TLMethod(val name: String, val id: Int, val parameters: List<TLParameter>, val tlType: TLType) : Comparable<TLMethod> {
    override fun toString() = "$name#${hex(id)}"
    override fun compareTo(other: TLMethod) = name.compareTo(other.name)
    override fun equals(other: Any?) = other is TLMethod && other.name == name && other.id == id
    override fun hashCode() = toString().hashCode()
}

// A parameter
class TLParameter(val name: String, val tlType: TLType) : Comparable<TLParameter> {
    var inherited = false

    override fun toString() = "$name: $tlType"
    override fun compareTo(other: TLParameter) = name.compareTo(other.name)
    override fun equals(other: Any?) = other is TLParameter && other.name == name && other.tlType == tlType
    override fun hashCode() = toString().hashCode()
}