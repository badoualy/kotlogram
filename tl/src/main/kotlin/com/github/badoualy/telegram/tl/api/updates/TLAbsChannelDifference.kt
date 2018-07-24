package com.github.badoualy.telegram.tl.api.updates

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import kotlin.Boolean
import kotlin.Int

/**
 * Abstraction level for the following constructors:
 * * [updates.channelDifference#2064674e][TLChannelDifference]
 * * [updates.channelDifferenceEmpty#3e11affb][TLChannelDifferenceEmpty]
 * * [updates.channelDifferenceTooLong#6a9d7b35][TLChannelDifferenceTooLong]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsChannelDifference : TLObject() {
    abstract var _final: Boolean

    abstract var pts: Int

    abstract var timeout: Int?
}
