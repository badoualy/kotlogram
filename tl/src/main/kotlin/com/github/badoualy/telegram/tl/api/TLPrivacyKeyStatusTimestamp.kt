package com.github.badoualy.telegram.tl.api

/**
 * privacyKeyStatusTimestamp#bc2eab30
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPrivacyKeyStatusTimestamp : TLAbsPrivacyKey() {
    private val _constructor: String = "privacyKeyStatusTimestamp#bc2eab30"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPrivacyKeyStatusTimestamp) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xbc2eab30.toInt()
    }
}
