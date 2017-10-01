package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputPhoto#fb95c6c4][TLInputPhoto]
 * * [inputPhotoEmpty#1cd7bf0d][TLInputPhotoEmpty]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputPhoto : TLObject() {
    fun isEmpty(): Boolean = this is TLInputPhotoEmpty

    fun isNotEmpty(): Boolean = this is TLInputPhoto

    fun asInputPhoto(): TLInputPhoto? = this as? TLInputPhoto
}
