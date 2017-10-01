package com.github.badoualy.telegram.tl.api

/**
 * phoneCallDiscardReasonMissed#85e42301
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPhoneCallDiscardReasonMissed : TLAbsPhoneCallDiscardReason() {
    private val _constructor: String = "phoneCallDiscardReasonMissed#85e42301"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPhoneCallDiscardReasonMissed) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x85e42301.toInt()
    }
}
