package com.github.badoualy.telegram.tl.builder

import java.util.*

/**
 * Support only for Vector generics
 */
fun checkType(t: TLType) {
    if (t is TLTypeGeneric) {
        if (!t.name.equals("Vector", false))
            throw RuntimeException("Only `Vector` generics are supported ${t.name}");
    }
}

fun checkType(t: TLType, availableTypes: HashSet<String>) {
    if (t is TLTypeGeneric) {
        if (!availableTypes.contains(t.name)) {
            throw RuntimeException("Unknown `" + t.name + "` generic type");
        }

        for (g in t.generics) {
            checkType(g, availableTypes)
        }
    } else if (t is TLTypeRaw) {
        if (!availableTypes.contains(t.name)) {
            throw RuntimeException("Unknown `" + t.name + "` type");
        }
    }
}

fun checkDefinition(definition: TLDefinition) {
    // Checking supported types
    for (constr in definition.contructors) {
        if (constr.tlType is TLTypeGeneric) {
            throw RuntimeException("Generic types are not supported as custom types")
        }
        checkType(constr.tlType);
        for (p in constr.parameters) {
            checkType(p.tlType);
        }
    }

    // Type system constraints
    var availableTypes = HashSet<String>()
    for (builtIn in BuiltInTypes) {
        availableTypes.add(builtIn)
    }

    for (constr in definition.contructors) {
        if (constr.tlType is TLTypeRaw) {
            availableTypes.add((constr.tlType as TLTypeRaw).name);
        }
    }

    for (constr in definition.contructors) {
        for (p in constr.parameters) {
            checkType(p.tlType)
        }
    }

    for (constr in definition.methods) {
        for (p in constr.parameters) {
            checkType(p.tlType)
        }
        checkType(constr.tlType)
    }
}

fun getTypeReference(sourceType: TLType, types: HashMap<String, TLTypeDef>): TLTypeDef {
    return if (sourceType is TLTypeRaw) {
        var rawType = sourceType
        if (BuiltInTypes.any { x -> rawType.name == x } ) {
            TLBuiltInTypeDef(rawType.name)
        } else {
            types[rawType.name]!!
        }
    } else if (sourceType is TLTypeAny) {
        TLAnyTypeDef()
    } else if (sourceType is TLTypeGeneric) {
        var generic = sourceType
        TLBuiltInGenericTypeDef(generic.name, getTypeReference(generic.generics[0], types))
    } else if (sourceType is TLTypeFunctional) {
        TLFunctionalTypeDef()
    } else {
        throw RuntimeException("Unknown type")
    }
}

fun buildParameterDef(sourceType: TLParameter, types: HashMap<String, TLTypeDef>): TLParameterDef {
    return TLParameterDef(sourceType.name, getTypeReference(sourceType.tlType, types))
}

fun buildModel(definition: TLDefinition): TLModel {
    var typeMap = HashMap<String, TLTypeDef>()

    // Prepopulate all types without constructors in combined types
    // to avoid issueses with references
    for (constr in definition.contructors) {
        if (constr.tlType is TLTypeGeneric) {
            throw RuntimeException("Generics are not supported as custom types");
        } else if (constr.tlType is TLTypeRaw) {
            if (BuiltInTypes.any { x -> (constr.tlType as TLTypeRaw).name == x } ) {
                throw RuntimeException("Found " + constr.toString() + " for built-in type");
            } else {
                var rawType = constr.tlType as TLTypeRaw;
                if (!typeMap.containsKey(rawType.name)) {
                    typeMap.put(rawType.name, TLCombinedTypeDef(rawType.name, ArrayList<TLConstructorDef>()))
                }
            }
        } else if (constr.tlType is TLTypeAny) {
            // When we create constructor without particular type
            typeMap.put(constr.name, TLAnonymousTypeDef(constr))
        } else {
            throw RuntimeException("Functional arguments in constructors are not supported")
        }
    }

    // Fill all constructors

    for (constr in definition.contructors) {
        if (constr.tlType is TLTypeRaw) {
            var rawType = constr.tlType as TLTypeRaw;
            var typedef = typeMap[rawType.name] as TLCombinedTypeDef

            var paramDefs = ArrayList<TLParameterDef>()
            for (p in constr.parameters) {
                paramDefs.add(buildParameterDef(p, typeMap))
            }
            var constrDef = TLConstructorDef(constr.name, constr.id, paramDefs)
            typedef.constructors.add(constrDef);
        }
    }

    var methods = ArrayList<TLMethodDef>()

    for (method in definition.methods) {

        var returnType = getTypeReference(method.tlType, typeMap)

        var paramDefs = ArrayList<TLParameterDef>()
        for (p in method.parameters) {
            paramDefs.add(buildParameterDef(p, typeMap))
        }

        methods.add(TLMethodDef(method.name, method.id, paramDefs, returnType))

    }

    return TLModel(typeMap.values.toList(), methods)
}