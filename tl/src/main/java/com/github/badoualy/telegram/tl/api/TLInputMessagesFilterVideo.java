package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMessagesFilterVideo extends TLAbsMessagesFilter {
    public static final int CLASS_ID = 0x9fc00e65;

    public TLInputMessagesFilterVideo() {
    }

    @Override
    public String toString() {
        return "inputMessagesFilterVideo#9fc00e65";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
