package com.github.badoualy.telegram.tl.api.messages

/**
 * messages.favedStickersNotModified#9e8fa6d3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLFavedStickersNotModified : TLAbsFavedStickers() {
    private val _constructor: String = "messages.favedStickersNotModified#9e8fa6d3"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLFavedStickersNotModified) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9e8fa6d3.toInt()
    }
}
