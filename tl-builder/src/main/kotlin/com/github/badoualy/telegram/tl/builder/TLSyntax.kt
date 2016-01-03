package com.github.badoualy.telegram.tl.builder

// Main definition
class TLDefinition(
        var contructors: List<TLConstructor>,
        var methods: List<TLMethod>
)

// Types
abstract class TLType()

class TLTypeRaw(
        var name: String
) : TLType() {
    override fun toString(): String = name
}

class TLTypeGeneric(
        var name: String,
        var generics: Array<TLType>) : TLType() {
    override fun toString(): String = "Generic<" + name + ">"
}

class TLTypeAny() : TLType() {
    override fun toString(): String = "#Any"
}

class TLTypeFunctional(
        var name: String
) : TLType() {
    override fun toString(): String = "!" + name
}


// Constructors of combined types

class TLConstructor(
        var name: String,
        var id: Int,
        var parameters: List<TLParameter>,
        var tlType: TLType
) {
    override fun toString(): String = name + "#" + hex(id) + " -> " + tlType.toString();
}

// Methods for RPC calls

class TLMethod(
        var name: String,
        var id: Int,
        var parameters: List<TLParameter>,
        var tlType: TLType
) {
    override fun toString(): String = name + "#" + hex(id);
}

// Parameters

class TLParameter(
        var name: String,
        var tlType: TLType
)