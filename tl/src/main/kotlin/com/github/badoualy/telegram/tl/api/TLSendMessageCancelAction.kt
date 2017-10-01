package com.github.badoualy.telegram.tl.api

/**
 * sendMessageCancelAction#fd5ec8f5
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSendMessageCancelAction : TLAbsSendMessageAction() {
    private val _constructor: String = "sendMessageCancelAction#fd5ec8f5"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSendMessageCancelAction) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfd5ec8f5.toInt()
    }
}
