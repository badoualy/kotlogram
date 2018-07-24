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
 * * [chatPhoto#6153276a][TLChatPhoto]
 * * [chatPhotoEmpty#37c1011c][TLChatPhotoEmpty]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsChatPhoto : TLObject() {
    fun isEmpty(): Boolean = this is TLChatPhotoEmpty

    fun isNotEmpty(): Boolean = this is TLChatPhoto

    fun asChatPhoto(): TLChatPhoto? = this as? TLChatPhoto
}
