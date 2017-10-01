package com.github.badoualy.telegram.tl.api

/**
 * inputMessagesFilterGif#ffc86587
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMessagesFilterGif : TLAbsMessagesFilter() {
    private val _constructor: String = "inputMessagesFilterGif#ffc86587"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMessagesFilterGif) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xffc86587.toInt()
    }
}
