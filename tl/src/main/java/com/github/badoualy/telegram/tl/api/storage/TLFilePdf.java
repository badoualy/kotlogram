package com.github.badoualy.telegram.tl.api.storage;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLFilePdf extends TLAbsFileType {
    public static final int CLASS_ID = 0xae1e508d;

    public TLFilePdf() {
    }

    @Override
    public String toString() {
        return "storage.filePdf#ae1e508d";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
