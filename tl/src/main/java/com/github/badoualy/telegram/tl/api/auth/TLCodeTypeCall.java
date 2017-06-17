package com.github.badoualy.telegram.tl.api.auth;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLCodeTypeCall extends TLAbsCodeType {

    public static final int CONSTRUCTOR_ID = 0x741cd3e3;

    private final String _constructor = "auth.codeTypeCall#741cd3e3";

    public TLCodeTypeCall() {
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
