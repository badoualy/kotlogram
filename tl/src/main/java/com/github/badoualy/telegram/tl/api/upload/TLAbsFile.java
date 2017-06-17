package com.github.badoualy.telegram.tl.api.upload;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLFile}: upload.file#96a18d5</li>
 * <li>{@link TLFileCdnRedirect}: upload.fileCdnRedirect#1508485a</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsFile extends TLObject {

    public TLAbsFile() {
    }
}
