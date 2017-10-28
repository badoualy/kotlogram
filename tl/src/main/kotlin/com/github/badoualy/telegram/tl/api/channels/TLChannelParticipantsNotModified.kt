package com.github.badoualy.telegram.tl.api.channels

/**
 * channels.channelParticipantsNotModified#f0173fe9
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelParticipantsNotModified : TLAbsChannelParticipants() {
    private val _constructor: String = "channels.channelParticipantsNotModified#f0173fe9"

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelParticipantsNotModified) return false
        if (other === this) return true

        return true
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf0173fe9.toInt()
    }
}
