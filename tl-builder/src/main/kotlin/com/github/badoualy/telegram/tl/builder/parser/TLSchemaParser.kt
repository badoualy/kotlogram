package com.github.badoualy.telegram.tl.builder.parser

import java.io.File
import java.io.FileInputStream
import java.io.InputStream

object TLSchemaParser {

    private val tlTypeRegex = "([^#]+)#([a-f0-9]+) ([^=]*?) ?= ([^;]+);".toRegex()

    fun parseTlSchema(file: File): Pair<List<ConstructorDef>, List<ConstructorDef>> {
        return parseTlSchema(FileInputStream(file))
    }

    fun parseTlSchema(`is`: InputStream): Pair<List<ConstructorDef>, List<ConstructorDef>> {
        val defList = splitTlSchema(`is`)

        val typesDef = mapToConstructorDef(defList.first, true)
        val methodsDef = mapToConstructorDef(defList.second, false)

        return Pair(typesDef, methodsDef)
    }

    fun parseJsonSchema(file: File): Pair<List<ConstructorDef>, List<ConstructorDef>> {
        // TODO
        throw NotImplementedError()
    }

    private fun splitTlSchema(stream: InputStream): Pair<List<String>, List<String>> {
        val nodes = Pair(ArrayList<String>(), ArrayList<String>())

        var parsingMethods = false
        stream.reader().forEachLine { line ->
            when {
                line.isBlank() -> Unit
                line.startsWith("//") -> Unit
                line == "---types---" -> parsingMethods = false
                line == "---functions---" -> parsingMethods = true
                !tlTypeRegex.matches(line.trim()) ->
                    System.err.println("Line not matching tlTypeRegex:\n$line")
                else -> {
                    (if (!parsingMethods)
                        nodes.first
                    else
                        nodes.second).add(line.trim())
                }
            }
        }

        return nodes
    }

    /** Split def list between types and methods constructors */
    private fun splitTlSchema(file: File): Pair<List<String>, List<String>> {
        return splitTlSchema(FileInputStream(file))
    }

    private fun mapToConstructorDef(constructorsDef: List<String>, skipIgnoredType: Boolean) = constructorsDef.mapNotNull { def ->
        val groups = tlTypeRegex.matchEntire(def)!!.groups

        val name = groups[1]!!.value
        val id = groups[2]!!.value.toLong(16)
        val paramsDef = if (groups.size == 5) groups[3]!!.value.trim().split(' ') else emptyList()
        val type = groups.last()!!.value

        if (skipIgnoredType && IgnoredTypes.contains(type))
            return@mapNotNull null

        val parameters = paramsDef.mapNotNull { paramDef ->
            when {
                paramDef.isBlank() -> null
                paramDef.replace(" ", "") == "{X:Type}" -> null
                else -> {
                    val fields = paramDef.split(':')
                    Pair(fields[0], fields[1])
                }
            }
        }

        ConstructorDef(name, id.toInt(), parameters, type)
    }

    data class ConstructorDef(val name: String, val id: Int, val parameters: List<Pair<String, String>>, val type: String)
}