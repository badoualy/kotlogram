package com.github.badoualy.telegram.tl.builder

import com.github.badoualy.telegram.tl.builder.parser.TLDefinitionBuilder
import com.github.badoualy.telegram.tl.builder.parser.TLSchemaParser
import com.github.badoualy.telegram.tl.builder.poet.TLClassGenerator

private val TL_SCHEMA_LEVEL = 82
private val TL_SCHEMA_PATH = "./tl-builder/src/main/resources/tl-schema-$TL_SCHEMA_LEVEL.tl"
private val MTPROTO_TL_SCHEMA_PATH = "./tl-builder/src/main/resources/mtproto-tl-schema.tl"

val OUTPUT = "./tl/src/main/kotlin"
val OUTPUT_TEST = "./tl/src/test/kotlin"

fun main(args: Array<String>) {
    println("TL Compiler developed by Yannick Badoual, Kotlogram (c) 2016 v2.0")

    val tlSchemaFile = ClassLoader.getSystemClassLoader()
            .getResourceAsStream("tl-schema-$TL_SCHEMA_LEVEL.tl")!!
//            File(TL_SCHEMA_PATH)
    val tlDef = TLDefinitionBuilder.build(TLSchemaParser.parseTlSchema(tlSchemaFile))
    TLClassGenerator(tlDef, TLClassGenerator.Config(OUTPUT, OUTPUT_TEST)).generate()
}