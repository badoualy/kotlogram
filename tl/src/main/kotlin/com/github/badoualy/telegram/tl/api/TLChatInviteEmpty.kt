package com.github.badoualy.telegram.tl.api

/**
 * chatInviteEmpty#69df3769
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChatInviteEmpty : TLAbsExportedChatInvite() {
    private val _constructor: String = "chatInviteEmpty#69df3769"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChatInviteEmpty) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x69df3769.toInt()
    }
}
