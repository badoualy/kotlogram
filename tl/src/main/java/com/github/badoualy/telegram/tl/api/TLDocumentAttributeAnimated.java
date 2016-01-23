package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLDocumentAttributeAnimated extends TLAbsDocumentAttribute {
    public static final int CLASS_ID = 0x11b58939;

    public TLDocumentAttributeAnimated() {
    }

    @Override
    public String toString() {
        return "documentAttributeAnimated#11b58939";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
