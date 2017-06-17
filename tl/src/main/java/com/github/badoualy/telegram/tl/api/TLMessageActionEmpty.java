package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageActionEmpty extends TLAbsMessageAction {

    public static final int CONSTRUCTOR_ID = 0xb6aef7b0;

    private final String _constructor = "messageActionEmpty#b6aef7b0";

    public TLMessageActionEmpty() {
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
