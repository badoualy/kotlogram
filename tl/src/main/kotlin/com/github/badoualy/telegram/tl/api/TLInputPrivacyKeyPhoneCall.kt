package com.github.badoualy.telegram.tl.api

/**
 * inputPrivacyKeyPhoneCall#fabadc5f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPrivacyKeyPhoneCall : TLAbsInputPrivacyKey() {
    private val _constructor: String = "inputPrivacyKeyPhoneCall#fabadc5f"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPrivacyKeyPhoneCall) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfabadc5f.toInt()
    }
}
