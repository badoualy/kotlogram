package com.github.badoualy.telegram.tl.builder.parser

object TLDefinitionBuilder {

    private val genericRegex = Regex("([a-zA-Z]+)<([a-zA-Z]+)>") // Vector<SomeKindOfType>
    private val flagRegex = Regex("([a-zA-Z]+).(\\d+)\\?([a-zA-Z<>.]+)") // flags.0?true
    private val rawRegex = Regex("[a-zA-Z].+")

    private val typeMap = HashMap<String, TLTypeRaw>()

    fun build(pair: Pair<List<TLSchemaParser.ConstructorDef>, List<TLSchemaParser.ConstructorDef>>): TLDefinition {
        typeMap.clear()
        println("Reading TL-Schema...")

        val (typesDef, methodsDef) = pair

        // Create all types
        typesDef.map { it.type }.distinct()
                .map { Pair(it, createConstructorType(it)) }
                .toMap(typeMap)

        // Create all types constructors
        val typesConstructors = typesDef.map {
            TLConstructor(it.name,
                          it.id,
                          it.parameters.map { TLParameter(it.first, createType(it.second)) },
                          typeMap[it.type]!!)
        }

        // Create all methods constructors
        val methodsConstructors = methodsDef.map {
            TLMethod(it.name,
                     it.id,
                     it.parameters.map { TLParameter(it.first, createType(it.second)) },
                     createType(it.type, false))
        }

        // Create abstraction-layer with common supertype for types having multiple constructors
        val supertypes = typeMap.values
                .map { type -> Pair(type, typesConstructors.count { it.tlType == type }) }
                .filter { it.second > 1 }

        val supertypesConstructors = supertypes.map {
            val tlType = it.first
            // Constructors that will have this common abstraction
            val subtypesConstructors = typesConstructors.filter { it.tlType == tlType }

            val forEmptyConstructor = it.second == 2 &&
                    subtypesConstructors.any { it.name.endsWith("empty", true) }

            val params = subtypesConstructors.map { it.parameters }.reduce { l1, l2 ->
                l1.intersect(l2).toList()
            }

            // Update each types parameters: reference are not the same
            subtypesConstructors.flatMap { it.parameters }.filter { params.contains(it) }.forEach {
                if (params.contains(it)) it.inherited = true
            }
            subtypesConstructors.forEach { it.hasSupertype = true }

            TLAbstractConstructor(tlType.name, params, tlType, forEmptyConstructor)
        }

        println("Found ${typesConstructors.size} types")
        println("Found ${methodsConstructors.size} methods")
        println("Found ${supertypesConstructors.size} supertypes")
        println("Found ${supertypesConstructors.count { it.forEmptyConstructor }} (for-empty) supertypes")

        return TLDefinition(supertypesConstructors.sorted(), typesConstructors.sorted(), methodsConstructors.sorted())
    }


    private fun createConstructorType(typeName: String): TLTypeRaw = when {
        typeName.matches(rawRegex) -> TLTypeRaw(typeName)
        else -> throw RuntimeException("Unsupported type $typeName for constructor/method}")
    }

    private fun createType(typeName: String, isParameter: Boolean = true): TLType = when {
        !isParameter && typeName == "X" -> TLTypeAny
        isParameter && typeName == "!X" -> TLTypeFunctional
        isParameter && typeName == "#" -> TLTypeFlag
        isParameter && typeName.matches(flagRegex) -> {
            val groups = flagRegex.matchEntire(typeName)?.groups!!
            val maskName = groups[1]?.value
                    ?: throw RuntimeException("Unknown error with type $typeName")
            val value = groups[2]?.value?.toInt()
                    ?: throw RuntimeException("Unknown error with type $typeName")
            val realType = groups[3]?.value
                    ?: throw RuntimeException("Unknown error with type $typeName")
            if (maskName != "flags")
                throw RuntimeException("Unsupported flag name, expected `flags`")

            TLTypeConditional(value, createType(realType))
        }
        typeName.matches(genericRegex) -> {
            val groups = genericRegex.matchEntire(typeName)?.groups!!
            val tlName: String = groups[1]?.value
                    ?: throw RuntimeException("Unknown error with type $typeName")
            val genericName: String = groups[2]?.value
                    ?: throw RuntimeException("Unknown error with type $typeName")
            if (!SupportedGenericTypes.contains(tlName))
                throw RuntimeException("Unsupported generic type $tlName")

            TLTypeGeneric(tlName, arrayOf(createType(genericName)))
        }
        typeName.matches(rawRegex) -> {
            when {
                BuiltInTypes.contains(typeName) -> TLTypeRaw(typeName)
                typeMap.containsKey(typeName) -> typeMap[typeName]!!
                else -> throw RuntimeException("Unknown type $typeName")
            }
        }
        else -> throw RuntimeException("Unsupported type $typeName for" +
                                               if (isParameter) "parameter"
                                               else "method")
    }

}
