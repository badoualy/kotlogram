package com.github.badoualy.telegram.tl.api.storage

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [storage.fileGif#cae1aadf][TLFileGif]
 * * [storage.fileJpeg#7efe0e][TLFileJpeg]
 * * [storage.fileMov#4b09ebbc][TLFileMov]
 * * [storage.fileMp3#528a0677][TLFileMp3]
 * * [storage.fileMp4#b3cea0e4][TLFileMp4]
 * * [storage.filePartial#40bc6f52][TLFilePartial]
 * * [storage.filePdf#ae1e508d][TLFilePdf]
 * * [storage.filePng#a4f63c0][TLFilePng]
 * * [storage.fileUnknown#aa963b05][TLFileUnknown]
 * * [storage.fileWebp#1081464c][TLFileWebp]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsFileType : TLObject()
