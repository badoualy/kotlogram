package com.github.badoualy.telegram.tl.api.messages

/**
 * messages.savedGifsNotModified#e8025ca2
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSavedGifsNotModified : TLAbsSavedGifs() {
    private val _constructor: String = "messages.savedGifsNotModified#e8025ca2"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSavedGifsNotModified) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe8025ca2.toInt()
    }
}
