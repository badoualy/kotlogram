package com.github.badoualy.telegram.tl.builder

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.badoualy.telegram.tl.builder.parser.buildFromJson
import com.github.badoualy.telegram.tl.builder.parser.buildModel
import com.github.badoualy.telegram.tl.builder.parser.checkDefinition
import com.github.badoualy.telegram.tl.builder.poet.JavaPackage
import com.github.badoualy.telegram.tl.builder.poet.convertToJavaModel
import com.github.badoualy.telegram.tl.builder.poet.writeJavaClasses
import java.io.File

private var TL_SCHEMA_LEVEL = 45
private var TL_SCHEMA_PATH = "./tl-builder/src/main/resources/tl-schema-%d.json".format(TL_SCHEMA_LEVEL)

private var DEFAULT_OUTPUT_PATH = "./tl"

private fun printUsage() {
    println("USAGE:")
    println("tlcompiler [-in <path_to_definition>] [-out <dest_folder>] [-package package]")
    println("Default input: " + TL_SCHEMA_PATH)
    println("Default output: " + TL_SCHEMA_PATH)
}

fun main(args: Array<String>) {
    println("TL Compiler developed by Yannick Badoual based on Stepan Korshakov's work, Kotlogram (c) 2015 v1.0")

    if (args.isNotEmpty()) {
        if (!arrayOf(2, 4, 6).contains(args.size)) {
            printUsage()
            return
        }

        if (args[0] != "-in") {
            printUsage()
            return
        } else {
            TL_SCHEMA_PATH = args[1]
        }
    }

    var destFolder = File(DEFAULT_OUTPUT_PATH).absolutePath

    if (args.size == 4) {
        if (args[2] != "-out" && args[2] != "-package") {
            printUsage()
            return
        } else {
            if (args[2] == "-out") {
                destFolder = args[3]
            } else {
                JavaPackage = args[3]
            }
        }
    }

    if (args.size == 6) {
        if (args[4] != "-package") {
            printUsage()
            return
        } else {
            JavaPackage = args[5]
        }
    }

    println("Reading definitions...")
    var sourceJsonTree = ObjectMapper().readValue(File(TL_SCHEMA_PATH), JsonNode::class.java)
    var definition = buildFromJson(sourceJsonTree)
    println("Checking definitions...")
    checkDefinition(definition)

    println("Building objects tl-model...")
    var model = buildModel(definition)

    println("Converting to java model...")
    var javaModel = convertToJavaModel(model)
    println("Generating classes for library...")
    writeJavaClasses(javaModel, destFolder + "/src/main/java/")
    println("[Sources] $destFolder + /src/main/java/")
}