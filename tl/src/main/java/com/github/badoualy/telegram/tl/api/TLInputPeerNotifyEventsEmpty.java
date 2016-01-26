package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPeerNotifyEventsEmpty extends TLAbsInputPeerNotifyEvents {
    public static final int CLASS_ID = 0xf03064d8;

    public TLInputPeerNotifyEventsEmpty() {
    }

    @Override
    public String toString() {
        return "inputPeerNotifyEventsEmpty#f03064d8";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public final boolean isEmpty() {
        return true;
    }

    @Override
    public final boolean isNotEmpty() {
        return false;
    }
}
