package com.github.badoualy.telegram.tl.builder.parser

import com.github.badoualy.telegram.tl.builder.hex

class FlagInfo(var value: Int, var maskName: String, var realTypeName: String)

// Main definition
class TLDefinition(var constructors: List<TLConstructor>, var methods: List<TLMethod>)

// Types
abstract class TLType()

class TLTypeRaw(var name: String) : TLType() {
    override fun toString() = name
}

class TLTypeGeneric(var name: String, var generics: Array<TLType>) : TLType() {
    override fun toString() = "Generic<$name>"
}

class TLTypeAny() : TLType() {
    override fun toString() = "#Any"
}

class TLTypeFunctional(var name: String) : TLType() {
    override fun toString() = "!$name"
}

class TLTypeFlag() : TLType() {
    override fun toString() = "#"
}

// Constructors of combined types
class TLConstructor(var name: String, var id: Int, var parameters: List<TLParameter>, var tlType: TLType) {
    override fun toString() = "$name#${hex(id)} -> ${tlType.toString()}"
}

// Methods for RPC calls
class TLMethod(var name: String, var id: Int, var parameters: List<TLParameter>, var tlType: TLType) {
    override fun toString() = "$name#${hex(id)}"
}

// Parameters
class TLParameter(var name: String, var tlType: TLType, var flagInfo: FlagInfo?)