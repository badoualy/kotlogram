package com.github.badoualy.telegram.tl.api.storage;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLFileJpeg extends TLAbsFileType {
    public static final int CLASS_ID = 0x7efe0e;

    public TLFileJpeg() {
    }

    @Override
    public String toString() {
        return "storage.fileJpeg#7efe0e";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
