package com.github.badoualy.telegram.mtproto.util

import java.math.BigInteger

internal open class Pair<out F, out S>(val first: F, val second: S) {

    override fun equals(other: Any?) = other is Pair<*, *> && other.first == first && other.second == second

    override fun hashCode() = (first?.hashCode() ?: 0) xor (second?.hashCode() ?: 0)

    companion object {
        fun <A, B> create(a: A, b: B) = Pair(a, b)
    }
}

// Some useful subclasses for convenience

internal class SolvedPQ(p: Long, q: Long) : Pair<BigInteger, BigInteger>(BigInteger.valueOf(Math.min(p, q)), BigInteger.valueOf(Math.max(p, q))) {
    val p = first
    val q = second
}

internal class AesKeyIvPair(key: ByteArray, iv: ByteArray) : Pair<ByteArray, ByteArray>(key, iv) {
    val key = first
    val iv = second
}