package com.github.badoualy.telegram.tl.api.upload;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLCdnFile}: upload.cdnFile#a99fca4f</li>
 * <li>{@link TLCdnFileReuploadNeeded}: upload.cdnFileReuploadNeeded#eea8e46e</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsCdnFile extends TLObject {

    public TLAbsCdnFile() {
    }
}
