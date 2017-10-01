package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

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
