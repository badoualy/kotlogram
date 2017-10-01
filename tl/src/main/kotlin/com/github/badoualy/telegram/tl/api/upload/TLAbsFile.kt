package com.github.badoualy.telegram.tl.api.upload

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [upload.file#96a18d5][TLFile]
 * * [upload.fileCdnRedirect#ea52fe5a][TLFileCdnRedirect]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsFile : TLObject()
