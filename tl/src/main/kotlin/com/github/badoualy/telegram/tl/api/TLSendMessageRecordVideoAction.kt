package com.github.badoualy.telegram.tl.api

/**
 * sendMessageRecordVideoAction#a187d66f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSendMessageRecordVideoAction : TLAbsSendMessageAction() {
    private val _constructor: String = "sendMessageRecordVideoAction#a187d66f"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSendMessageRecordVideoAction) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa187d66f.toInt()
    }
}
