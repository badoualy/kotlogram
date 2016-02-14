package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLDocumentAttributeAnimated extends TLAbsDocumentAttribute {
    public static final int CONSTRUCTOR_ID = 0x11b58939;

    private final String _constructor = "documentAttributeAnimated#11b58939";

    public TLDocumentAttributeAnimated() {
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLDocumentAttributeAnimated)) return false;
        if (object == this) return true;

        TLDocumentAttributeAnimated o = (TLDocumentAttributeAnimated) object;

        return true;
    }
}
