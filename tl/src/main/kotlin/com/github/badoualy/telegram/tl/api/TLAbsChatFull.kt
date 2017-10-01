package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector

/**
 * Abstraction level for the following constructors:
 * * [channelFull#17f45fcf][TLChannelFull]
 * * [chatFull#2e02a614][TLChatFull]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsChatFull : TLObject() {
    abstract var id: Int

    abstract var chatPhoto: TLAbsPhoto

    abstract var notifySettings: TLAbsPeerNotifySettings

    abstract var exportedInvite: TLAbsExportedChatInvite

    abstract var botInfo: TLObjectVector<TLBotInfo>
}
