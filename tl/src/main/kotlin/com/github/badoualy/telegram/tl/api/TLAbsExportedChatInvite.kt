package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import kotlin.Boolean

/**
 * Abstraction level for the following constructors:
 * * [chatInviteEmpty#69df3769][TLChatInviteEmpty]
 * * [chatInviteExported#fc2e05bc][TLChatInviteExported]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsExportedChatInvite : TLObject() {
    fun isEmpty(): Boolean = this is TLChatInviteEmpty

    fun isNotEmpty(): Boolean = this is TLChatInviteExported

    fun asChatInviteExported(): TLChatInviteExported? = this as? TLChatInviteExported
}
