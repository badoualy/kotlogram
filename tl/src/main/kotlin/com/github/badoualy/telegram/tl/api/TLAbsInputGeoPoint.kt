package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputGeoPoint#f3b7acc9][TLInputGeoPoint]
 * * [inputGeoPointEmpty#e4c123d6][TLInputGeoPointEmpty]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputGeoPoint : TLObject() {
    fun isEmpty(): Boolean = this is TLInputGeoPointEmpty

    fun isNotEmpty(): Boolean = this is TLInputGeoPoint

    fun asInputGeoPoint(): TLInputGeoPoint? = this as? TLInputGeoPoint
}
