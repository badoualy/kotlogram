package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [chatParticipant#c8d7493e][TLChatParticipant]
 * * [chatParticipantAdmin#e2d6e436][TLChatParticipantAdmin]
 * * [chatParticipantCreator#da13538a][TLChatParticipantCreator]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsChatParticipant : TLObject() {
    abstract var userId: Int
}
