package com.github.badoualy.telegram.tl.api

/**
 * inputPrivacyValueDisallowContacts#ba52007
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPrivacyValueDisallowContacts : TLAbsInputPrivacyRule() {
    private val _constructor: String = "inputPrivacyValueDisallowContacts#ba52007"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPrivacyValueDisallowContacts) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xba52007.toInt()
    }
}
