package com.github.badoualy.telegram.tl.api

/**
 * inputMessagesFilterVoice#50f5c392
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMessagesFilterVoice : TLAbsMessagesFilter() {
    private val _constructor: String = "inputMessagesFilterVoice#50f5c392"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMessagesFilterVoice) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x50f5c392.toInt()
    }
}
