package com.github.badoualy.telegram.tl.api

/**
 * sendMessageChooseContactAction#628cbc6f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSendMessageChooseContactAction : TLAbsSendMessageAction() {
    private val _constructor: String = "sendMessageChooseContactAction#628cbc6f"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSendMessageChooseContactAction) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x628cbc6f.toInt()
    }
}
