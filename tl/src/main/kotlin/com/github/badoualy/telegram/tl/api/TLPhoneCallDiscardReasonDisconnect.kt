package com.github.badoualy.telegram.tl.api

/**
 * phoneCallDiscardReasonDisconnect#e095c1a0
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPhoneCallDiscardReasonDisconnect : TLAbsPhoneCallDiscardReason() {
    private val _constructor: String = "phoneCallDiscardReasonDisconnect#e095c1a0"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPhoneCallDiscardReasonDisconnect) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe095c1a0.toInt()
    }
}
