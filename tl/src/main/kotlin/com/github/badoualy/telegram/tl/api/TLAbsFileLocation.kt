package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [fileLocation#53d69076][TLFileLocation]
 * * [fileLocationUnavailable#7c596b46][TLFileLocationUnavailable]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsFileLocation : TLObject() {
    abstract var volumeId: Long

    abstract var localId: Int

    abstract var secret: Long
}
