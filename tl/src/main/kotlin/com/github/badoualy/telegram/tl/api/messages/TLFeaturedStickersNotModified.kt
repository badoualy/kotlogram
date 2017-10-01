package com.github.badoualy.telegram.tl.api.messages

/**
 * messages.featuredStickersNotModified#4ede3cf
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLFeaturedStickersNotModified : TLAbsFeaturedStickers() {
    private val _constructor: String = "messages.featuredStickersNotModified#4ede3cf"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLFeaturedStickersNotModified) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4ede3cf.toInt()
    }
}
