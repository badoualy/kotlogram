package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [channelParticipantsAdmins#b4608969][TLChannelParticipantsAdmins]
 * * [channelParticipantsBanned#1427a5e1][TLChannelParticipantsBanned]
 * * [channelParticipantsBots#b0d1865b][TLChannelParticipantsBots]
 * * [channelParticipantsKicked#a3b54985][TLChannelParticipantsKicked]
 * * [channelParticipantsRecent#de3f3c79][TLChannelParticipantsRecent]
 * * [channelParticipantsSearch#656ac4b][TLChannelParticipantsSearch]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsChannelParticipantsFilter : TLObject()
