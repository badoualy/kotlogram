package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputUserSelf extends TLAbsInputUser {
    public static final int CLASS_ID = 0xf7c1b13f;

    public TLInputUserSelf() {
    }

    @Override
    public String toString() {
        return "inputUserSelf#f7c1b13f";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
