package com.github.badoualy.telegram.tl.api

/**
 * privacyKeyChatInvite#500e6dfa
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPrivacyKeyChatInvite : TLAbsPrivacyKey() {
    private val _constructor: String = "privacyKeyChatInvite#500e6dfa"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPrivacyKeyChatInvite) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x500e6dfa.toInt()
    }
}
