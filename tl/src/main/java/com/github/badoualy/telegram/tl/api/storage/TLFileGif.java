package com.github.badoualy.telegram.tl.api.storage;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLFileGif extends TLAbsFileType {
    public static final int CONSTRUCTOR_ID = 0xcae1aadf;

    public TLFileGif() {
    }

    @Override
    public String toString() {
        return "storage.fileGif#cae1aadf";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLFileGif)) return false;
        if (object == this) return true;

        TLFileGif o = (TLFileGif) object;

        return true;
    }
}
