package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLTrue extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x3fedd339;

    public TLTrue() {
    }

    @Override
    public String toString() {
        return "true#3fedd339";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
