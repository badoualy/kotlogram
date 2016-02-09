package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMessagesFilterDocument extends TLAbsMessagesFilter {
    public static final int CONSTRUCTOR_ID = 0x9eddf188;

    public TLInputMessagesFilterDocument() {
    }

    @Override
    public String toString() {
        return "inputMessagesFilterDocument#9eddf188";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputMessagesFilterDocument)) return false;
        if (object == this) return true;

        TLInputMessagesFilterDocument o = (TLInputMessagesFilterDocument) object;

        return true;
    }
}
