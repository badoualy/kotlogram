package com.github.badoualy.telegram.tl.builder.parser

import com.github.badoualy.telegram.tl.builder.config.BuiltInTypes
import com.github.badoualy.telegram.tl.builder.config.SupportedGenericTypes
import java.util.*

fun checkType(t: TLType, availableTypes: HashSet<String>) {
    when (t) {
        is TLTypeGeneric -> {
            if (!SupportedGenericTypes.contains(t.name))
                throw RuntimeException("${t.name} generic type is not supported. Supported types are ${SupportedGenericTypes.joinToString(", ")}")
            if (!availableTypes.contains(t.name))
                throw RuntimeException("Unknown `${t.name}` generic type")

            t.generics.forEach { g -> checkType(g, availableTypes) }
        }
        is TLTypeRaw -> {
            if (!availableTypes.contains(t.name))
                throw RuntimeException("Unknown `${t.name}` type")
        }
    }
}

fun checkDefinition(definition: TLDefinition) {
    // Checking supported types
    if (definition.constructors.map { c -> c.tlType }.filterIsInstance(TLTypeGeneric::class.java).isNotEmpty())
        throw RuntimeException("Generic types are not supported as custom types")

    // Type system constraints
    var availableTypes = HashSet<String>()
    // All core types (int, long, ...)
    availableTypes.addAll(BuiltInTypes)
    // Add all RawType (should be all of them, only raw type accepted as constructor)
    availableTypes.addAll(definition.constructors.map { c -> c.tlType }.filterIsInstance(TLTypeRaw::class.java).map { t -> t.name })

    // Check all constructors/methods parameters
    definition.constructors.flatMap { c -> c.parameters }.map { p -> p.tlType }.forEach { t -> checkType(t, availableTypes) }
    definition.constructors.map { c -> c.tlType }.forEach { t -> checkType(t, availableTypes) }
    definition.methods.flatMap { m -> m.parameters }.map { p -> p.tlType }.forEach { t -> checkType(t, availableTypes) }
    definition.methods.map { m -> m.tlType }.forEach { t -> checkType(t, availableTypes) }
}

fun buildModel(definition: TLDefinition): TLModel {
    var typeMap = HashMap<String, TLTypeDef>()

    // Prepopulate all types without constructors in combined types to avoid issues with references
    for (constructor in definition.constructors) {
        val tlType = constructor.tlType
        if (tlType is TLTypeRaw) {
            if (BuiltInTypes.contains(tlType.name))
                throw RuntimeException("Found ${constructor.toString()} for built-in type")

            if (!typeMap.containsKey(tlType.name))
                typeMap.put(tlType.name, TLCombinedTypeDef(tlType.name, ArrayList<TLConstructorDef>()))
        } else {
            throw RuntimeException("Unsupported constructor type ${constructor.name}")
        }
    }

    // Fill all constructors (TLType = AbstractTypes, constructors = subclasses)
    for (constructor in definition.constructors) {
        val tlType = constructor.tlType
        if (tlType is TLTypeRaw) {
            val parametersDef = constructor.parameters.map { p -> buildParameterDef(p, typeMap) }
            var constructorDef = TLConstructorDef(constructor.name, constructor.id, parametersDef)

            (typeMap[tlType.name] as TLCombinedTypeDef).constructors.add(constructorDef)
        }
    }

    // Fill all methods (API call)
    var methods = ArrayList<TLMethodDef>()
    for (method in definition.methods) {
        var returnType = getTypeReference(method.tlType, typeMap)
        val parametersDef = method.parameters.map { p -> buildParameterDef(p, typeMap) }

        methods.add(TLMethodDef(method.name, method.id, parametersDef, returnType))
    }

    return TLModel(typeMap.values.toList(), methods)
}

fun buildParameterDef(sourceType: TLParameter, types: HashMap<String, TLTypeDef>): TLParameterDef {
    val paramDef = TLParameterDef(sourceType.name, getTypeReference(sourceType.tlType, types))
    paramDef.flagInfo = sourceType.flagInfo
    return paramDef
}

fun getTypeReference(sourceType: TLType, types: HashMap<String, TLTypeDef>): TLTypeDef = when (sourceType) {
    is TLTypeRaw ->
        if (BuiltInTypes.contains(sourceType.name))
            TLBuiltInTypeDef(sourceType.name)
        else types[sourceType.name]!!
    is TLTypeAny -> TLAnyTypeDef()
    is TLTypeGeneric -> TLBuiltInGenericTypeDef(sourceType.name, getTypeReference(sourceType.generics[0], types))
    is TLTypeFunctional -> TLFunctionalTypeDef()
    is TLTypeFlag -> TLFlagTypeDef()
    else -> throw RuntimeException("Unknown type")
}