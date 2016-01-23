package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputNotifyUsers extends TLAbsInputNotifyPeer {
    public static final int CLASS_ID = 0x193b4417;

    public TLInputNotifyUsers() {
    }

    @Override
    public String toString() {
        return "inputNotifyUsers#193b4417";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
