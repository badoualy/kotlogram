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
 * * [channelMessagesFilter#cd77d957][TLChannelMessagesFilter]
 * * [channelMessagesFilterEmpty#94d42ee7][TLChannelMessagesFilterEmpty]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsChannelMessagesFilter : TLObject() {
    fun isEmpty(): Boolean = this is TLChannelMessagesFilterEmpty

    fun isNotEmpty(): Boolean = this is TLChannelMessagesFilter

    fun asChannelMessagesFilter(): TLChannelMessagesFilter? = this as? TLChannelMessagesFilter
}
