package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [geoPoint#2049d70c][TLGeoPoint]
 * * [geoPointEmpty#1117dd5f][TLGeoPointEmpty]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsGeoPoint : TLObject() {
    fun isEmpty(): Boolean = this is TLGeoPointEmpty

    fun isNotEmpty(): Boolean = this is TLGeoPoint

    fun asGeoPoint(): TLGeoPoint? = this as? TLGeoPoint
}
