package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [chatParticipants#3f460fed][TLChatParticipants]
 * * [chatParticipantsForbidden#fc900c2b][TLChatParticipantsForbidden]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsChatParticipants : TLObject() {
    abstract var chatId: Int
}
