package com.github.badoualy.telegram.tl.api

/**
 * updateLangPackTooLong#10c2404b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateLangPackTooLong : TLAbsUpdate() {
    private val _constructor: String = "updateLangPackTooLong#10c2404b"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateLangPackTooLong) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x10c2404b.toInt()
    }
}
