package com.github.badoualy.telegram.tl.api

/**
 * messageActionChatDeletePhoto#95e3fbef
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionChatDeletePhoto : TLAbsMessageAction() {
    private val _constructor: String = "messageActionChatDeletePhoto#95e3fbef"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionChatDeletePhoto) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x95e3fbef.toInt()
    }
}
