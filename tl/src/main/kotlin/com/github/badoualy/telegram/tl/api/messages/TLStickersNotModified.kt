package com.github.badoualy.telegram.tl.api.messages

/**
 * messages.stickersNotModified#f1749a22
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStickersNotModified : TLAbsStickers() {
    private val _constructor: String = "messages.stickersNotModified#f1749a22"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStickersNotModified) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf1749a22.toInt()
    }
}
