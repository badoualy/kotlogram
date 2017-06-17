package com.github.badoualy.telegram.tl.api.auth;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLCodeTypeFlashCall extends TLAbsCodeType {

    public static final int CONSTRUCTOR_ID = 0x226ccefb;

    private final String _constructor = "auth.codeTypeFlashCall#226ccefb";

    public TLCodeTypeFlashCall() {
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
