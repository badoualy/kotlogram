package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector

/**
 * Abstraction level for the following constructors:
 * * [messages.chats#64ff9fd5][TLChats]
 * * [messages.chatsSlice#9cd81144][TLChatsSlice]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsChats : TLObject() {
    abstract var chats: TLObjectVector<TLAbsChat>
}
