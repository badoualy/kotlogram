package com.github.badoualy.telegram.tl.api

/**
 * sendMessageTypingAction#16bf744e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSendMessageTypingAction : TLAbsSendMessageAction() {
    private val _constructor: String = "sendMessageTypingAction#16bf744e"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSendMessageTypingAction) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x16bf744e.toInt()
    }
}
