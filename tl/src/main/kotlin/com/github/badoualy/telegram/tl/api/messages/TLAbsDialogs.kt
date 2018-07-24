package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLAbsMessage
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLDialog
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector

/**
 * Abstraction level for the following constructors:
 * * [messages.dialogs#15ba6c40][TLDialogs]
 * * [messages.dialogsNotModified#f0e3e596][TLDialogsNotModified]
 * * [messages.dialogsSlice#71e094f3][TLDialogsSlice]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsDialogs : TLObject() {
    abstract var dialogs: TLObjectVector<TLDialog>

    abstract var messages: TLObjectVector<TLAbsMessage>

    abstract var chats: TLObjectVector<TLAbsChat>

    abstract var users: TLObjectVector<TLAbsUser>
}
