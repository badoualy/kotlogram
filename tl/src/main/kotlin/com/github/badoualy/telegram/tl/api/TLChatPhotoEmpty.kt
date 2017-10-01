package com.github.badoualy.telegram.tl.api

/**
 * chatPhotoEmpty#37c1011c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChatPhotoEmpty : TLAbsChatPhoto() {
    private val _constructor: String = "chatPhotoEmpty#37c1011c"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChatPhotoEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x37c1011c.toInt()
    }
}
