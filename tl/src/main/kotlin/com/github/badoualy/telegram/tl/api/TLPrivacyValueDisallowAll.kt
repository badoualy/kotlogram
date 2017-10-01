package com.github.badoualy.telegram.tl.api

/**
 * privacyValueDisallowAll#8b73e763
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPrivacyValueDisallowAll : TLAbsPrivacyRule() {
    private val _constructor: String = "privacyValueDisallowAll#8b73e763"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPrivacyValueDisallowAll) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8b73e763.toInt()
    }
}
