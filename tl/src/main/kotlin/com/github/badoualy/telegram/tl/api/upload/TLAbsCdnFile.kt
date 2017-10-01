package com.github.badoualy.telegram.tl.api.upload

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [upload.cdnFile#a99fca4f][TLCdnFile]
 * * [upload.cdnFileReuploadNeeded#eea8e46e][TLCdnFileReuploadNeeded]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsCdnFile : TLObject()
