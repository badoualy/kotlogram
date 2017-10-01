package com.github.badoualy.telegram.tl.api

/**
 * sendMessageRecordRoundAction#88f27fbc
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSendMessageRecordRoundAction : TLAbsSendMessageAction() {
    private val _constructor: String = "sendMessageRecordRoundAction#88f27fbc"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSendMessageRecordRoundAction) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x88f27fbc.toInt()
    }
}
