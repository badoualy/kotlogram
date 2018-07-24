package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import kotlin.Int

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
