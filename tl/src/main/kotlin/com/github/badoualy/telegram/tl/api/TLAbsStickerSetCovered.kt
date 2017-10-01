package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [stickerSetCovered#6410a5d2][TLStickerSetCovered]
 * * [stickerSetMultiCovered#3407e51b][TLStickerSetMultiCovered]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsStickerSetCovered : TLObject() {
    abstract var set: TLStickerSet
}
