package com.github.badoualy.telegram.tl.api

/**
 * sendMessageRecordAudioAction#d52f73f7
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSendMessageRecordAudioAction : TLAbsSendMessageAction() {
    private val _constructor: String = "sendMessageRecordAudioAction#d52f73f7"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSendMessageRecordAudioAction) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd52f73f7.toInt()
    }
}
