package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [wallPaper#ccb03657][TLWallPaper]
 * * [wallPaperSolid#63117f24][TLWallPaperSolid]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsWallPaper : TLObject() {
    abstract var id: Int

    abstract var title: String

    abstract var color: Int
}
