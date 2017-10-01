package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputFile#f52ff27f][TLInputFile]
 * * [inputFileBig#fa4f0bb5][TLInputFileBig]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputFile : TLObject() {
    abstract var id: Long

    abstract var parts: Int

    abstract var name: String
}
