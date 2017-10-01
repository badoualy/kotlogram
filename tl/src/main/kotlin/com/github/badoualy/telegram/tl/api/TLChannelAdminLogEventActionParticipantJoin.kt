package com.github.badoualy.telegram.tl.api

/**
 * channelAdminLogEventActionParticipantJoin#183040d3
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelAdminLogEventActionParticipantJoin : TLAbsChannelAdminLogEventAction() {
    private val _constructor: String = "channelAdminLogEventActionParticipantJoin#183040d3"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelAdminLogEventActionParticipantJoin) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x183040d3.toInt()
    }
}
