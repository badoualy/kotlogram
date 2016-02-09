package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMessagesFilterPhotos extends TLAbsMessagesFilter {
    public static final int CONSTRUCTOR_ID = 0x9609a51c;

    public TLInputMessagesFilterPhotos() {
    }

    @Override
    public String toString() {
        return "inputMessagesFilterPhotos#9609a51c";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputMessagesFilterPhotos)) return false;
        if (object == this) return true;

        TLInputMessagesFilterPhotos o = (TLInputMessagesFilterPhotos) object;

        return true;
    }
}
