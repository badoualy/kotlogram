package com.github.badoualy.telegram.tl.api

/**
 * sendMessageGamePlayAction#dd6a8f48
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSendMessageGamePlayAction : TLAbsSendMessageAction() {
    private val _constructor: String = "sendMessageGamePlayAction#dd6a8f48"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSendMessageGamePlayAction) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xdd6a8f48.toInt()
    }
}
