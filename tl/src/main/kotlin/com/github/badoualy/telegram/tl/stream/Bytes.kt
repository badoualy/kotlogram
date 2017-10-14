package com.github.badoualy.telegram.tl.stream

fun Int.toBytes() = byteArrayOf((this and 0xFF).toByte(),
                                (this shr 8 and 0xFF).toByte(),
                                (this shr 16 and 0xFF).toByte(),
                                (this shr 24 and 0xFF).toByte())

fun Long.toBytes() = byteArrayOf((this and 0xFF).toByte(),
                                 (this shr 8 and 0xFF).toByte(),
                                 (this shr 16 and 0xFF).toByte(),
                                 (this shr 24 and 0xFF).toByte(),
                                 (this shr 32 and 0xFF).toByte(),
                                 (this shr 40 and 0xFF).toByte(),
                                 (this shr 48 and 0xFF).toByte(),
                                 (this shr 56 and 0xFF).toByte())

fun ByteArray.readConstructorId(offset: Int = 0) = readInt(offset)

fun ByteArray.readInt(offset: Int = 0): Int {
    val a = this[offset].toInt() and 0xFF
    val b = this[offset + 1].toInt() and 0xFF
    val c = this[offset + 2].toInt() and 0xFF
    val d = this[offset + 3].toInt() and 0xFF

    return a + (b shl 8) + (c shl 16) + (d shl 24)
}

fun ByteArray.readUInt(offset: Int = 0): Long {
    val a = this[offset].toLong() and 0xFF
    val b = this[offset + 1].toLong() and 0xFF
    val c = this[offset + 2].toLong() and 0xFF
    val d = this[offset + 3].toLong() and 0xFF

    return a + (b shl 8) + (c shl 16) + (d shl 24)
}

fun ByteArray.readLong(offset: Int = 0): Long {
    val a = readUInt(offset)
    val b = readUInt(offset + 4)

    return (a and 0xFFFFFFFF) + (b and 0xFFFFFFFF shl 32)
}

private val hexArray = "0123456789ABCDEF".toCharArray()

fun ByteArray.toHexString(): String {
    val hexChars = CharArray(size * 2)
    for (j in indices) {
        val v = this[j].toInt() and 0xFF
        hexChars[j * 2] = hexArray[v.ushr(4)]
        hexChars[j * 2 + 1] = hexArray[v and 0x0F]
    }
    return String(hexChars)
}
