package com.github.badoualy.telegram.tl.api

/**
 * inputPrivacyValueAllowContacts#d09e07b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPrivacyValueAllowContacts : TLAbsInputPrivacyRule() {
    private val _constructor: String = "inputPrivacyValueAllowContacts#d09e07b"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPrivacyValueAllowContacts) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd09e07b.toInt()
    }
}
