package com.github.badoualy.telegram.tl.api

/**
 * privacyKeyPhoneCall#3d662b7b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPrivacyKeyPhoneCall : TLAbsPrivacyKey() {
    private val _constructor: String = "privacyKeyPhoneCall#3d662b7b"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPrivacyKeyPhoneCall) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3d662b7b.toInt()
    }
}
