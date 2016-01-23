package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPeerNotifyEventsAll extends TLAbsInputPeerNotifyEvents {
    public static final int CLASS_ID = 0xe86a2c74;

    public TLInputPeerNotifyEventsAll() {
    }

    @Override
    public String toString() {
        return "inputPeerNotifyEventsAll#e86a2c74";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
