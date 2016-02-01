package com.github.badoualy.telegram.tl.api.storage;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLFileUnknown extends TLAbsFileType {
    public static final int CONSTRUCTOR_ID = 0xaa963b05;

    public TLFileUnknown() {
    }

    @Override
    public String toString() {
        return "storage.fileUnknown#aa963b05";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
