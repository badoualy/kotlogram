package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [channelParticipant#15ebac1d][TLChannelParticipant]
 * * [channelParticipantAdmin#a82fa898][TLChannelParticipantAdmin]
 * * [channelParticipantBanned#222c1886][TLChannelParticipantBanned]
 * * [channelParticipantCreator#e3e2e1f9][TLChannelParticipantCreator]
 * * [channelParticipantSelf#a3289a6d][TLChannelParticipantSelf]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsChannelParticipant : TLObject() {
    abstract var userId: Int
}
