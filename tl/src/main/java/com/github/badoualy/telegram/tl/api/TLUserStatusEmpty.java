package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUserStatusEmpty extends TLAbsUserStatus {
    public static final int CLASS_ID = 0x9d05049;

    public TLUserStatusEmpty() {
    }

    @Override
    public String toString() {
        return "userStatusEmpty#9d05049";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
