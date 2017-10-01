package com.github.badoualy.telegram.tl.api

/**
 * channelAdminLogEventActionParticipantLeave#f89777f2
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelAdminLogEventActionParticipantLeave : TLAbsChannelAdminLogEventAction() {
    private val _constructor: String = "channelAdminLogEventActionParticipantLeave#f89777f2"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelAdminLogEventActionParticipantLeave) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf89777f2.toInt()
    }
}
