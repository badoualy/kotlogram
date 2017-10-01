package com.github.badoualy.telegram.tl.api

/**
 * updatesTooLong#e317af7e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdatesTooLong : TLAbsUpdates() {
    private val _constructor: String = "updatesTooLong#e317af7e"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdatesTooLong) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe317af7e.toInt()
    }
}
