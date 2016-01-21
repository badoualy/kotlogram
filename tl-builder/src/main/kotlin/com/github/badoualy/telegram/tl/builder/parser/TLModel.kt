package com.github.badoualy.telegram.tl.builder.parser

import com.github.badoualy.telegram.tl.builder.uFirstLetter
import java.util.*

class TLModel(var types: List<TLTypeDef>, var methods: List<TLMethodDef>)

class TLMethodDef(var name: String, var id: Int, var args: List<TLParameterDef>, var returnType: TLTypeDef)

class TLConstructorDef(var name: String, var id: Int, var parameters: List<TLParameterDef>)

class TLParameterDef(var name: String, var typeDef: TLTypeDef){
    var flagInfo: FlagInfo? = null
}

abstract class TLTypeDef(var name: String)

class TLCombinedTypeDef(name: String, var constructors: ArrayList<TLConstructorDef>) : TLTypeDef(name) {
    override fun toString(): String = name;

    override fun equals(other: Any?) = other is TLCombinedTypeDef && other.name == name
}

class TLAnonymousTypeDef(var constructor: TLConstructor) : TLTypeDef(constructor.name.uFirstLetter()) {
    override fun toString(): String = "anonymous:$name";

    override fun equals(other: Any?) = other is TLAnonymousTypeDef && other.name == name
}

class TLBuiltInGenericTypeDef(name: String, var basic: TLTypeDef) : TLTypeDef(name) {
    override fun toString(): String = "b-generic:$name<${basic.toString()}>";

    override fun equals(other: Any?): Boolean {
        if (other is TLBuiltInGenericTypeDef) {
            return (name == other.name) && (basic.name == other.basic.name);
        }
        return false;
    }
}

class TLBuiltInTypeDef(name: String) : TLTypeDef(name) {
    override fun toString(): String = "built-in:$name";

    override fun equals(other: Any?) = other is TLBuiltInTypeDef && other.name == name
}

class TLAnyTypeDef() : TLTypeDef("") {
    override fun toString(): String = "any";

    override fun equals(other: Any?) = other is TLAnyTypeDef
}

class TLFunctionalTypeDef() : TLTypeDef("") {
    override fun toString(): String = "functional";

    override fun equals(other: Any?) = other is TLFunctionalTypeDef
}

class TLFlagTypeDef() : TLTypeDef("flag") {
    override fun toString(): String = "flag:$name";

    override fun equals(other: Any?) = other is TLFlagTypeDef
}