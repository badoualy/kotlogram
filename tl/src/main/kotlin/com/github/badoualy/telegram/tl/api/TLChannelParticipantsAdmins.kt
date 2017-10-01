package com.github.badoualy.telegram.tl.api

/**
 * channelParticipantsAdmins#b4608969
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelParticipantsAdmins : TLAbsChannelParticipantsFilter() {
    private val _constructor: String = "channelParticipantsAdmins#b4608969"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelParticipantsAdmins) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb4608969.toInt()
    }
}
