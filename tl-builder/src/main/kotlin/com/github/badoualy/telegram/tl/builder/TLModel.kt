package com.github.badoualy.telegram.tl.builder

import java.util.*

class TLModel(var types: List<TLTypeDef>, var methods: List<TLMethodDef>)

class TLParameterDef(var name: String,
                     var typeDef: TLTypeDef)

class TLConstructorDef(var name: String,
                       var id: Int,
                       var parameters: List<TLParameterDef>)

abstract class TLTypeDef(var name: String)

class TLCombinedTypeDef(name: String, var constructors: ArrayList<TLConstructorDef>) : TLTypeDef(name) {
    override fun toString(): String = name;
    override fun equals(other: Any?): Boolean {
        if (other is TLCombinedTypeDef) {
            return name == other.name;
        }
        return false;
    }
}

class TLAnonymousTypeDef(var constructor: TLConstructor) : TLTypeDef(constructor.name.uFirstLetter()) {
    override fun toString(): String = "anonymous:" + name;

    override fun equals(other: Any?): Boolean {
        if (other is TLAnonymousTypeDef) {
            return name == other.name;
        }
        return false;
    }
}

class TLAnyTypeDef() : TLTypeDef("") {
    override fun toString(): String = "any";

    override fun equals(other: Any?): Boolean {
        if (other is TLAnyTypeDef) {
            return true;
        }
        return false;
    }
}

class TLFunctionalTypeDef() : TLTypeDef("") {
    override fun toString(): String = "functional";

    override fun equals(other: Any?): Boolean {
        if (other is TLFunctionalTypeDef) {
            return true;
        }
        return false;
    }
}

class TLBuiltInGenericTypeDef(name: String, var basic: TLTypeDef) : TLTypeDef(name) {
    override fun toString(): String = "b-generic:" + name + "<" + basic.toString() + ">";

    override fun equals(other: Any?): Boolean {
        if (other is TLBuiltInGenericTypeDef) {
            return (name == other.name) && (basic.name == other.basic.name);
        }
        return false;
    }
}

class TLBuiltInTypeDef(name: String) : TLTypeDef(name) {
    override fun toString(): String = "built-in:" + name;

    override fun equals(other: Any?): Boolean {
        if (other is TLBuiltInTypeDef) {
            return (name == other.name);
        }
        return false;
    }
}

class TLMethodDef(var name: String, var id: Int, var args: List<TLParameterDef>, var returnType: TLTypeDef)