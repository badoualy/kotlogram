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
 * * [channelAdminLogEventActionChangeAbout#55188a2e][TLChannelAdminLogEventActionChangeAbout]
 * * [channelAdminLogEventActionChangePhoto#b82f55c3][TLChannelAdminLogEventActionChangePhoto]
 * * [channelAdminLogEventActionChangeStickerSet#b1c3caa7][TLChannelAdminLogEventActionChangeStickerSet]
 * * [channelAdminLogEventActionChangeTitle#e6dfb825][TLChannelAdminLogEventActionChangeTitle]
 * * [channelAdminLogEventActionChangeUsername#6a4afc38][TLChannelAdminLogEventActionChangeUsername]
 * * [channelAdminLogEventActionDeleteMessage#42e047bb][TLChannelAdminLogEventActionDeleteMessage]
 * * [channelAdminLogEventActionEditMessage#709b2405][TLChannelAdminLogEventActionEditMessage]
 * * [channelAdminLogEventActionParticipantInvite#e31c34d8][TLChannelAdminLogEventActionParticipantInvite]
 * * [channelAdminLogEventActionParticipantJoin#183040d3][TLChannelAdminLogEventActionParticipantJoin]
 * * [channelAdminLogEventActionParticipantLeave#f89777f2][TLChannelAdminLogEventActionParticipantLeave]
 * * [channelAdminLogEventActionParticipantToggleAdmin#d5676710][TLChannelAdminLogEventActionParticipantToggleAdmin]
 * * [channelAdminLogEventActionParticipantToggleBan#e6d83d7e][TLChannelAdminLogEventActionParticipantToggleBan]
 * * [channelAdminLogEventActionToggleInvites#1b7907ae][TLChannelAdminLogEventActionToggleInvites]
 * * [channelAdminLogEventActionTogglePreHistoryHidden#5f5c95f1][TLChannelAdminLogEventActionTogglePreHistoryHidden]
 * * [channelAdminLogEventActionToggleSignatures#26ae0971][TLChannelAdminLogEventActionToggleSignatures]
 * * [channelAdminLogEventActionUpdatePinned#e9e82c18][TLChannelAdminLogEventActionUpdatePinned]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsChannelAdminLogEventAction : TLObject()
