package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPeerNotifyEventsEmpty extends TLAbsPeerNotifyEvents {
    public static final int CONSTRUCTOR_ID = 0xadd53cb3;

    public TLPeerNotifyEventsEmpty() {
    }

    @Override
    public String toString() {
        return "peerNotifyEventsEmpty#add53cb3";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLPeerNotifyEventsEmpty)) return false;
        if (object == this) return true;

        TLPeerNotifyEventsEmpty o = (TLPeerNotifyEventsEmpty) object;

        return true;
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
