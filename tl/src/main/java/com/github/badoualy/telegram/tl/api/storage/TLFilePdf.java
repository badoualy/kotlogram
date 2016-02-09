package com.github.badoualy.telegram.tl.api.storage;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLFilePdf extends TLAbsFileType {
    public static final int CONSTRUCTOR_ID = 0xae1e508d;

    public TLFilePdf() {
    }

    @Override
    public String toString() {
        return "storage.filePdf#ae1e508d";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLFilePdf)) return false;
        if (object == this) return true;

        TLFilePdf o = (TLFilePdf) object;

        return true;
    }
}
