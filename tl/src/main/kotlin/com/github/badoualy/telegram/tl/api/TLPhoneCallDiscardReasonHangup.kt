package com.github.badoualy.telegram.tl.api

/**
 * phoneCallDiscardReasonHangup#57adc690
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPhoneCallDiscardReasonHangup : TLAbsPhoneCallDiscardReason() {
    private val _constructor: String = "phoneCallDiscardReasonHangup#57adc690"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPhoneCallDiscardReasonHangup) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x57adc690.toInt()
    }
}
