package com.github.badoualy.telegram.tl.builder.poet

import com.github.badoualy.telegram.tl.builder.parser.*
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.TypeName

internal fun serializeParameter(fieldName: String, fieldTlType: TLType): String = when (fieldTlType) {
    is TLTypeFunctional -> "writeTLMethod($fieldName, stream)"
    is TLTypeFlag -> "writeInt($fieldName, stream)"
    is TLTypeConditional -> {
        val statement = StringBuilder()
        statement.append("if ((flags and ${fieldTlType.pow2Value()}) != 0) {\n")
                .append("    ")
        if (fieldTlType.realType !is TLTypeRaw || fieldTlType.realType.name != "Bool") {
            statement.append("""if ($fieldName == null) throwNullFieldException("$fieldName", flags)""").append(
                    '\n')
                    .append("    ")
        }
        statement.append(serializeParameter(fieldName, fieldTlType.realType)).append('\n')
                .append('}')
        statement.toString()
    }
    is TLTypeGeneric -> "writeTLVector($fieldName, stream)"
    is TLTypeRaw -> when (fieldTlType.name) {
        "int" -> "writeInt($fieldName, stream)"
        "long" -> "writeLong($fieldName, stream)"
        "double" -> "writeDouble($fieldName, stream)"
        "float" -> "writeFloat($fieldName, stream)"
        "string" -> "writeString($fieldName, stream)"
        "bytes" -> "writeTLBytes($fieldName, stream)"
        "Bool" -> "writeBoolean($fieldName, stream)"
        "true", "false" -> ""
        else -> "writeTLObject($fieldName, stream)"
    }
    else -> throw RuntimeException("Unsupported type $fieldTlType")
}

internal fun deserializeParameter(fieldTlType: TLType, fieldType: TypeName): String = when (fieldTlType) {
    is TLTypeFunctional -> "readTLMethod(stream, context) as TLMethod<T>?"
    is TLTypeFlag -> "readInt(stream)"
    is TLTypeConditional -> {
        val prefix = "(flags and ${fieldTlType.pow2Value()}) != 0"
        val realType = fieldTlType.realType
        val suffix = if (realType is TLTypeRaw && "Bool" == realType.name) "false" else "null"

        if (realType is TLTypeRaw && arrayOf("true", "false").contains(realType.name)) prefix
        else "if ($prefix) ${deserializeParameter(realType, fieldType)} else $suffix"
    }
    is TLTypeGeneric -> when ((fieldTlType.parameters.first() as TLTypeRaw).name) {
        "int" -> "readTLIntVector(stream, context)"
        "long" -> "readTLLongVector(stream, context)"
        "string" -> "readTLStringVector(stream, context)"
        else -> "readTLVector(stream, context) as %T"
    }
    is TLTypeRaw -> when (fieldTlType.name) {
        "int" -> "readInt(stream)"
        "long" -> "readLong(stream)"
        "double" -> "readDouble(stream)"
        "float" -> "readFloat(stream)"
        "string" -> "readTLString(stream)"
        "bytes" -> "readTLBytes(stream, context)"
        "Bool" -> "readTLBool(stream)"
        else -> {
            val className = (fieldType as ClassName).simpleName()
            val isAbstract = className.startsWith("TLAbs", true)
            val constructorId = if (isAbstract) "-1" else "%T.CONSTRUCTOR_ID"
            "readTLObject(stream, context, %T::class.java, $constructorId)"
        }
    }
    else -> throw RuntimeException("Unsupported type $fieldTlType")
}

internal fun computeSizeParameter(fieldName: String, fieldTlType: TLType): String = when (fieldTlType) {
    is TLTypeFunctional -> "size += $fieldName!!.computeSerializedSize()"
    is TLTypeFlag -> "size += SIZE_INT32"
    is TLTypeConditional -> {
        val statement = StringBuilder()
        statement.append("if ((flags and ${fieldTlType.pow2Value()}) != 0) {\n")
                .append("    ")
        if (fieldTlType.realType !is TLTypeRaw || fieldTlType.realType.name != "Bool") {
            statement.append("""if ($fieldName == null) throwNullFieldException("$fieldName", flags)""").append(
                    '\n')
                    .append("    ")
        }
        statement.append(computeSizeParameter(fieldName, fieldTlType.realType)).append("\n")
                .append('}')
        statement.toString()
    }
    is TLTypeGeneric -> "size += $fieldName?.computeSerializedSize() ?: 0"
    is TLTypeRaw -> {
        val name = fieldTlType.name
        when (name) {
            "int" -> "size += SIZE_INT32"
            "long" -> "size += SIZE_INT64"
            "double" -> "size += SIZE_DOUBLE"
            "float" -> "size += SIZE_DOUBLE"
            "string" -> "size += computeTLStringSerializedSize($fieldName)"
            "bytes" -> "size += computeTLBytesSerializedSize($fieldName)"
            "Bool" -> "size += SIZE_BOOLEAN"
            else -> "size += $fieldName?.computeSerializedSize() ?: 0"
        }
    }
    else -> throw RuntimeException("Unsupported type $fieldTlType")
}