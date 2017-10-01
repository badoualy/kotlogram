package com.github.badoualy.telegram.tl.api

/**
 * inputPrivacyValueAllowAll#184b35ce
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPrivacyValueAllowAll : TLAbsInputPrivacyRule() {
    private val _constructor: String = "inputPrivacyValueAllowAll#184b35ce"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPrivacyValueAllowAll) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x184b35ce.toInt()
    }
}
