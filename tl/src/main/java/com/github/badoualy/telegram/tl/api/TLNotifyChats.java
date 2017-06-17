package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLNotifyChats extends TLAbsNotifyPeer {

    public static final int CONSTRUCTOR_ID = 0xc007cec3;

    private final String _constructor = "notifyChats#c007cec3";

    public TLNotifyChats() {
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
