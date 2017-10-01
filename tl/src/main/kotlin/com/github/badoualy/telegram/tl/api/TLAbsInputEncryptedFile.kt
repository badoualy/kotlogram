package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [inputEncryptedFile#5a17b5e5][TLInputEncryptedFile]
 * * [inputEncryptedFileBigUploaded#2dc173c8][TLInputEncryptedFileBigUploaded]
 * * [inputEncryptedFileEmpty#1837c364][TLInputEncryptedFileEmpty]
 * * [inputEncryptedFileUploaded#64bd0306][TLInputEncryptedFileUploaded]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsInputEncryptedFile : TLObject()
