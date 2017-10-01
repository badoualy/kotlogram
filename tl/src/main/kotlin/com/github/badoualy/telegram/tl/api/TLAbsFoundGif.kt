package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [foundGif#162ecc1f][TLFoundGif]
 * * [foundGifCached#9c750409][TLFoundGifCached]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsFoundGif : TLObject() {
    abstract var url: String
}
