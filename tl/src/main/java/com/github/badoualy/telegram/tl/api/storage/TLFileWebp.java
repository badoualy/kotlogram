package com.github.badoualy.telegram.tl.api.storage;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLFileWebp extends TLAbsFileType {
    public static final int CONSTRUCTOR_ID = 0x1081464c;

    public TLFileWebp() {
    }

    @Override
    public String toString() {
        return "storage.fileWebp#1081464c";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLFileWebp)) return false;
        if (object == this) return true;

        TLFileWebp o = (TLFileWebp) object;

        return true;
    }
}
