package com.github.badoualy.telegram.tl.builder

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File

fun printUsage() {
    println("USAGE:")
    println("tlcompiler -in <path_to_definition> [-out <dest_folder>] [-package package]")
}

fun main(args: Array<String>) {
    println("TL Compiler based on Stepan Korshakov's work, Kotlogram (c) 2015 v1.0")

    var inputDefinition = "./tl-builder/src/main/resources/tl-schema-18.json"

    if (!args.isEmpty()) {
        if (args.size != 2 && args.size != 4 && args.size != 6) {
            printUsage()
            return
        }

        if (args[0] != "-in") {
            printUsage()
            return
        } else {
            inputDefinition = args[1]
        }
    }

    var destFolder = File("./tl/").absolutePath

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
            JavaPackage = args.get(5)
        }
    }

    println("Reading definitions...")
    var mapper = ObjectMapper()
    var sourceJsonTree = mapper.readValue (File(inputDefinition), JsonNode::class.java)
    var definition = buildFromJson(sourceJsonTree)
    println("Building objects tl-model...")
    checkDefinition(definition)
    var model = buildModel(definition)
    println("Converting to java model...")
    var javaModel = convertToJavaModel(model)
    println("Generating classes for library...")
    writeJavaClasses(javaModel, destFolder + "/src/main/java/")
    //    println("Compiling classes...")
    //    compileClasses(destFolder + "/src/main/java/" + JavaPackage.replace(".", "/"), destFolder, "bin");
    //    println("Building jar...")
    //    buildJar("bin", "tl-api.jar", destFolder)
    //    println("Operation completed successfuly")
    println("[Sources]")
    println("\t" + destFolder + "/src/main/java/")
    //    println("[JAR]")
    //    println("\t" + destFolder + "/tl-api.jar")
}