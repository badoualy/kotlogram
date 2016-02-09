package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputDocumentEmpty extends TLAbsInputDocument {
    public static final int CONSTRUCTOR_ID = 0x72f0eaae;

    public TLInputDocumentEmpty() {
    }

    @Override
    public String toString() {
        return "inputDocumentEmpty#72f0eaae";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputDocumentEmpty)) return false;
        if (object == this) return true;

        TLInputDocumentEmpty o = (TLInputDocumentEmpty) object;

        return true;
    }

    @Override
    public final boolean isEmpty() {
        return true;
    }

    @Override
    public final boolean isNotEmpty() {
        return false;
    }
}
