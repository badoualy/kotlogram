package com.github.badoualy.telegram.tl.api.messages

/**
 * messages.recentStickersNotModified#b17f890
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRecentStickersNotModified : TLAbsRecentStickers() {
    private val _constructor: String = "messages.recentStickersNotModified#b17f890"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRecentStickersNotModified) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb17f890.toInt()
    }
}
