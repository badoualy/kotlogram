package com.github.badoualy.telegram.tl.builder.parser

import com.github.badoualy.telegram.tl.builder.utils.hexString

// Main definition
class TLDefinition(val supertypes: List<TLAbstractConstructor>, val types: List<TLConstructor>, val methods: List<TLMethod>)

// Base classes
abstract class TLType : Comparable<TLType> {

    abstract val name: String

    open fun serializable() = true

    override fun toString() = name

    override fun equals(other: Any?) = other is TLType && toString() == other.toString()
    override fun hashCode() = toString().hashCode()

    override fun compareTo(other: TLType) = toString().compareTo(other.toString())
}

abstract class TLTypeConstructor<out T : TLType> : TLType() {

    open val id: Int? = null
    abstract val parameters: List<TLParameter>
    abstract val tlType: T

    override fun toString() = "$name#${id?.hexString()}"
}

///////////////////////////////////
////////////// TYPES /////////////
/////////////////////////////////
data class TLTypeRaw(override val name: String) : TLType()

class TLTypeGeneric(override val name: String, val parameters: Array<TLType>) : TLType() {
    override fun toString() = "Generic<$name>"
}

object TLTypeAny : TLType() {
    override val name = "#Any"
}

object TLTypeFunctional : TLType() {
    override val name = "#Functional"
}

object TLTypeFlag : TLType() {
    override val name = "#Flag"
}

class TLTypeConditional(val value: Int, val realType: TLType) : TLType() {
    override val name = "Conditional(${realType.name})"

    fun pow2Value() = Math.pow(2.toDouble(), value.toDouble()).toInt()

    // TODO: check if needed
    override fun serializable() = !(realType is TLTypeRaw && realType.name.equals("true", true))

    override fun toString() = "flag.$value?$realType"
}

///////////////////////////////////
////////// CONSTRUCTORS //////////
/////////////////////////////////
class TLConstructor(override val name: String,
                    override val id: Int,
                    override val parameters: List<TLParameter>,
                    override val tlType: TLTypeRaw,
                    var hasSupertype: Boolean = false) : TLTypeConstructor<TLTypeRaw>()

class TLAbstractConstructor(override val name: String,
                            override val parameters: List<TLParameter>,
                            override val tlType: TLTypeRaw,
                            val forEmptyConstructor: Boolean) : TLTypeConstructor<TLTypeRaw>()

class TLMethod(override val name: String,
               override val id: Int,
               override val parameters: List<TLParameter>,
               override val tlType: TLType) : TLTypeConstructor<TLType>()

class TLParameter(val name: String, val tlType: TLType) : Comparable<TLParameter> {
    /** true if inherited from abstract parent (aka parameter is common to all constructors of the same type) */
    var inherited = false

    override fun toString() = "$name: $tlType"

    override fun compareTo(other: TLParameter) = name.compareTo(other.name)
    override fun equals(other: Any?) = other is TLParameter && other.name == name && other.tlType == tlType
    override fun hashCode() = toString().hashCode()
}