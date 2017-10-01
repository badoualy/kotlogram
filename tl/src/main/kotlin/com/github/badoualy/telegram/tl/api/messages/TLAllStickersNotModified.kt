package com.github.badoualy.telegram.tl.api.messages

/**
 * messages.allStickersNotModified#e86602c3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAllStickersNotModified : TLAbsAllStickers() {
    private val _constructor: String = "messages.allStickersNotModified#e86602c3"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAllStickersNotModified) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe86602c3.toInt()
    }
}
