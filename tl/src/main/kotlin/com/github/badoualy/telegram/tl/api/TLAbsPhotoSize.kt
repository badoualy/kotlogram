package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [photoCachedSize#e9a734fa][TLPhotoCachedSize]
 * * [photoSize#77bfb61b][TLPhotoSize]
 * * [photoSizeEmpty#e17e23c][TLPhotoSizeEmpty]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPhotoSize : TLObject() {
    abstract var type: String
}
