package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLAbsMessage
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector

/**
 * Abstraction level for the following constructors:
 * * [messages.channelMessages#99262e37][TLChannelMessages]
 * * [messages.messages#8c718e87][TLMessages]
 * * [messages.messagesSlice#b446ae3][TLMessagesSlice]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsMessages : TLObject() {
    abstract var messages: TLObjectVector<TLAbsMessage>

    abstract var chats: TLObjectVector<TLAbsChat>

    abstract var users: TLObjectVector<TLAbsUser>
}
