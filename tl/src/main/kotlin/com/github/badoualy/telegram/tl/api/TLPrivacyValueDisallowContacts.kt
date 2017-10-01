package com.github.badoualy.telegram.tl.api

/**
 * privacyValueDisallowContacts#f888fa1a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPrivacyValueDisallowContacts : TLAbsPrivacyRule() {
    private val _constructor: String = "privacyValueDisallowContacts#f888fa1a"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPrivacyValueDisallowContacts) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf888fa1a.toInt()
    }
}
