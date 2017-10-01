package com.github.badoualy.telegram.tl.api

/**
 * inputMessagesFilterPhotos#9609a51c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMessagesFilterPhotos : TLAbsMessagesFilter() {
    private val _constructor: String = "inputMessagesFilterPhotos#9609a51c"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMessagesFilterPhotos) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9609a51c.toInt()
    }
}
