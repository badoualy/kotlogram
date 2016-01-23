package com.github.badoualy.telegram.tl.api.storage;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLFileGif extends TLAbsFileType {
    public static final int CLASS_ID = 0xcae1aadf;

    public TLFileGif() {
    }

    @Override
    public String toString() {
        return "storage.fileGif#cae1aadf";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
