package com.github.badoualy.telegram.tl.builder

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.badoualy.telegram.tl.builder.parser.buildFromJson
import com.github.badoualy.telegram.tl.builder.poet.JavaPoet
import java.io.File

private val TL_SCHEMA_LEVEL = 45
private val TL_SCHEMA_PATH = "./tl-builder/src/main/resources/tl-schema-%d.json".format(TL_SCHEMA_LEVEL)

fun main(args: Array<String>) {
    println("TL Compiler developed by Yannick Badoual, Kotlogram (c) 2015 v1.0")

    var tlSchemaNode = ObjectMapper().readValue(File(TL_SCHEMA_PATH), JsonNode::class.java)
    var definition = buildFromJson(tlSchemaNode)

    JavaPoet.writeClasses(definition)
}