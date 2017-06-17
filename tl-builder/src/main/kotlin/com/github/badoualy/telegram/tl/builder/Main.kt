package com.github.badoualy.telegram.tl.builder

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.badoualy.telegram.tl.builder.parser.buildFromJson
import com.github.badoualy.telegram.tl.builder.poet.JavaPoet
import java.io.File

private val TL_SCHEMA_LEVEL = 66
private val TL_SCHEMA_PATH = "./tl-builder/src/main/resources/tl-schema-$TL_SCHEMA_LEVEL.json"

val OUTPUT = "./tl/src/main/java"
val OUTPUT_TEST = "./tl/src/test/java"

//val tlRegex = "([^#]+)#([a-f0-9]+) (?:([^:]+):([^ ]+) )*= ([^;]+);".toRegex()

fun main(args: Array<String>) {
    println("TL Compiler developed by Yannick Badoual, Kotlogram (c) 2016 v1.0")

    val tlSchemaNode = ObjectMapper().readValue(File(TL_SCHEMA_PATH), JsonNode::class.java)
    val definition = buildFromJson(tlSchemaNode)

    JavaPoet.writeClasses(definition)
}