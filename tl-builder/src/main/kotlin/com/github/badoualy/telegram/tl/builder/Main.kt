package com.github.badoualy.telegram.tl.builder

import com.github.badoualy.telegram.tl.builder.parser.TLDefinitionBuilder
import com.github.badoualy.telegram.tl.builder.parser.TLSchemaParser
import com.github.badoualy.telegram.tl.builder.poet.TLClassGenerator
import java.io.File

private val TL_SCHEMA_LEVEL = 72
private val TL_SCHEMA_PATH = "./tl-builder/src/main/resources/tl-schema-$TL_SCHEMA_LEVEL.tl"
private val MTPROTO_TL_SCHEMA_PATH = "./tl-builder/src/main/resources/mtproto-tl-schema.tl"

val OUTPUT = "./tl/src/main/kotlin"
val OUTPUT_TEST = "./tl/src/test/kotlin"

fun main(args: Array<String>) {
    println("TL Compiler developed by Yannick Badoual, Kotlogram (c) 2016 v2.0")

    val tlSchemaFile = File(TL_SCHEMA_PATH)

    val tlDef = TLDefinitionBuilder.build(TLSchemaParser.parseTlSchema(tlSchemaFile))
    TLClassGenerator(tlDef, TLClassGenerator.Config(OUTPUT, OUTPUT_TEST)).generate()
}