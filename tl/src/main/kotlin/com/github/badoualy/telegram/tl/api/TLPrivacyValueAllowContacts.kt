package com.github.badoualy.telegram.tl.api

/**
 * privacyValueAllowContacts#fffe1bac
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPrivacyValueAllowContacts : TLAbsPrivacyRule() {
    private val _constructor: String = "privacyValueAllowContacts#fffe1bac"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPrivacyValueAllowContacts) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfffe1bac.toInt()
    }
}
