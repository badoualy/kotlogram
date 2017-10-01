package com.github.badoualy.telegram.tl.api

/**
 * inputMessagesFilterDocument#9eddf188
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMessagesFilterDocument : TLAbsMessagesFilter() {
    private val _constructor: String = "inputMessagesFilterDocument#9eddf188"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMessagesFilterDocument) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9eddf188.toInt()
    }
}
