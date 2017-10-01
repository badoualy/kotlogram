package com.github.badoualy.telegram.tl.api

/**
 * updateRecentStickers#9a422c20
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateRecentStickers : TLAbsUpdate() {
    private val _constructor: String = "updateRecentStickers#9a422c20"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateRecentStickers) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9a422c20.toInt()
    }
}
