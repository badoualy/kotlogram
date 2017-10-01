package com.github.badoualy.telegram.tl.api

/**
 * inputMessagesFilterMusic#3751b49e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMessagesFilterMusic : TLAbsMessagesFilter() {
    private val _constructor: String = "inputMessagesFilterMusic#3751b49e"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMessagesFilterMusic) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3751b49e.toInt()
    }
}
