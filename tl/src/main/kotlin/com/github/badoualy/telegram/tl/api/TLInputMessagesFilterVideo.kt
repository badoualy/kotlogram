package com.github.badoualy.telegram.tl.api

/**
 * inputMessagesFilterVideo#9fc00e65
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMessagesFilterVideo : TLAbsMessagesFilter() {
    private val _constructor: String = "inputMessagesFilterVideo#9fc00e65"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMessagesFilterVideo) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9fc00e65.toInt()
    }
}
