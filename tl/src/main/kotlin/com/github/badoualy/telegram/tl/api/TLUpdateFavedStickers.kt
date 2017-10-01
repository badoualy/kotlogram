package com.github.badoualy.telegram.tl.api

/**
 * updateFavedStickers#e511996d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateFavedStickers : TLAbsUpdate() {
    private val _constructor: String = "updateFavedStickers#e511996d"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateFavedStickers) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe511996d.toInt()
    }
}
