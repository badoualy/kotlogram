package com.github.badoualy.telegram.tl.api.storage;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLFileGif}: storage.fileGif#cae1aadf</li>
 * <li>{@link TLFileJpeg}: storage.fileJpeg#7efe0e</li>
 * <li>{@link TLFileMov}: storage.fileMov#4b09ebbc</li>
 * <li>{@link TLFileMp3}: storage.fileMp3#528a0677</li>
 * <li>{@link TLFileMp4}: storage.fileMp4#b3cea0e4</li>
 * <li>{@link TLFilePartial}: storage.filePartial#40bc6f52</li>
 * <li>{@link TLFilePdf}: storage.filePdf#ae1e508d</li>
 * <li>{@link TLFilePng}: storage.filePng#a4f63c0</li>
 * <li>{@link TLFileUnknown}: storage.fileUnknown#aa963b05</li>
 * <li>{@link TLFileWebp}: storage.fileWebp#1081464c</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsFileType extends TLObject {

    public TLAbsFileType() {
    }
}
