package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import kotlin.Int

/**
 * Abstraction level for the following constructors:
 * * [channelFull#76af5481][TLChannelFull]
 * * [chatFull#2e02a614][TLChatFull]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsChatFull : TLObject() {
    abstract var id: Int

    abstract var chatPhoto: TLAbsPhoto

    abstract var notifySettings: TLPeerNotifySettings

    abstract var exportedInvite: TLAbsExportedChatInvite

    abstract var botInfo: TLObjectVector<TLBotInfo>
}
