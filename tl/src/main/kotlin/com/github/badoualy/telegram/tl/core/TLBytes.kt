package com.github.badoualy.telegram.tl.core

import java.util.Arrays

/**
 * Convenience class to wrap a [ByteArray] with an offset/len
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see [http://github.com/badoualy/kotlogram](http://github.com/badoualy/kotlogram)
 */
class TLBytes @JvmOverloads constructor(data: ByteArray, offset: Int = 0, len: Int = data.size) {

    var data = data
        private set
    var offset = offset
        private set
    var length = len
        private set

    override fun equals(other: Any?): Boolean {
        if (other !is TLBytes)
            return false
        if (this === other)
            return true

        // TODO: Arrays.equals on offset/length only...
        return offset == other.offset
                && length == other.length
                && Arrays.equals(data, other.data)
    }

    override fun hashCode(): Int {
        var result = Arrays.hashCode(data)
        result = 31 * result + offset
        result = 31 * result + length
        return result
    }

    companion object {
        val EMPTY = TLBytes(ByteArray(0))
    }
}