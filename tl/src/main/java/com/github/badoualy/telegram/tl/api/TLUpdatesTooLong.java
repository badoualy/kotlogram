package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdatesTooLong extends TLAbsUpdates {
    public static final int CLASS_ID = 0xe317af7e;

    public TLUpdatesTooLong() {
    }

    @Override
    public String toString() {
        return "updatesTooLong#e317af7e";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
