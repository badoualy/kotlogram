package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [photo#9288dd29][TLPhoto]
 * * [photoEmpty#2331b22d][TLPhotoEmpty]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPhoto : TLObject() {
    abstract var id: Long

    fun isEmpty(): Boolean = this is TLPhotoEmpty

    fun isNotEmpty(): Boolean = this is TLPhoto

    fun asPhoto(): TLPhoto? = this as? TLPhoto
}
