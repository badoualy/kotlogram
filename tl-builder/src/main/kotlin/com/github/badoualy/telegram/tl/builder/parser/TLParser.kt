package com.github.badoualy.telegram.tl.builder.parser

import com.fasterxml.jackson.databind.JsonNode
import com.github.badoualy.telegram.tl.builder.config.IgnoredTypes
import java.util.*

private val genericRegex = Regex("([a-zA-Z]+)<([a-zA-Z]+)>") // Vector<SomeKindOfType>
private val flagRegex = Regex("([a-zA-Z]+).(\\d+)\\?([a-zA-Z<>]+)") // flags.0?true

fun createTypeFromName(typeName: String): Pair<TLType, FlagInfo?> = when (typeName) {
    "X" -> Pair(TLTypeAny(), null)
    "!X" -> Pair(TLTypeFunctional("X"), null)
    "#" -> Pair(TLTypeFlag(), null)
    else -> {
        if (typeName.matches(flagRegex)) {
            val groups = flagRegex.matchEntire(typeName)?.groups
            var maskName = groups?.get(1)?.value ?: throw RuntimeException("Unknown error with type $typeName")
            var value = groups?.get(2)?.value?.toInt() ?: throw RuntimeException("Unknown error with type $typeName")
            var type = groups?.get(3)?.value ?: throw RuntimeException("Unknown error with type $typeName")
            var realType = type

            if (type == "true" || type == "false")
                type = "Bool"

            Pair(createTypeFromName(type).first, FlagInfo(Math.pow(2.toDouble(), value.toDouble()).toInt(), maskName, realType))
        } else if (typeName.matches(genericRegex)) {
            val groups = genericRegex.matchEntire(typeName)?.groups
            var tlName = groups?.get(1)?.value ?: throw RuntimeException("Unknown error with type $typeName")
            var genericName = groups?.get(2)?.value ?: throw RuntimeException("Unknown error with type $typeName")

            Pair(TLTypeGeneric(tlName, arrayOf(createTypeFromName(genericName).first)), null)
        } else {
            Pair(TLTypeRaw(typeName), null)
        }
    }
}

fun buildFromJson(root: JsonNode): TLDefinition {
    var sourceConstructors = ArrayList<TLConstructor>()
    var sourceMethods = ArrayList<TLMethod>()

    // Build constructors : type classes
    var constructors = root.get("constructors").filterNot { c -> IgnoredTypes.contains(c.get("type")!!.textValue()) }
    for (constructor in constructors) {
        var name = constructor.get("predicate")!!.textValue()!!
        var id = constructor.get("id")!!.textValue()!!.toInt()
        var tlType = createTypeFromName(constructor.get("type")!!.textValue()).first
        var constructorParameters = ArrayList<TLParameter>()

        var paramsNode = constructor.get("params")
        for (p in paramsNode!!.iterator()) {
            var paramName = p.get("name")!!.textValue().toString()
            var paramType = p.get("type")!!.textValue().toString()
            val paramTypeFromName = createTypeFromName(paramType)
            constructorParameters.add(TLParameter(paramName, paramTypeFromName.first, paramTypeFromName.second))
        }

        sourceConstructors.add(TLConstructor(name, id, constructorParameters, tlType))
    }

    // Build methods remote-call classes
    var methods = root.get("methods")
    for (method in methods) {
        var name = method.get("method")!!.textValue()!!
        var id = method.get("id")!!.textValue()!!.toInt()
        var tlType = createTypeFromName(method.get("type")!!.textValue()).first
        var constructorParameters = ArrayList<TLParameter>()

        var paramsNode = method.get("params")
        for (p in paramsNode!!.iterator()) {
            var paramName = p.get("name")!!.textValue()
            var paramType = p.get("type")!!.textValue()
            val paramTypeFromName = createTypeFromName(paramType)
            constructorParameters.add(TLParameter(paramName, paramTypeFromName.first, paramTypeFromName.second))
        }

        sourceMethods.add(TLMethod(name, id, constructorParameters, tlType))
    }

    return TLDefinition(sourceConstructors, sourceMethods)
}