package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPeerNotifyEventsAll extends TLAbsPeerNotifyEvents {

    public static final int CONSTRUCTOR_ID = 0x6d1ded88;

    private final String _constructor = "peerNotifyEventsAll#6d1ded88";

    public TLPeerNotifyEventsAll() {
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLPeerNotifyEventsAll getAsPeerNotifyEventsAll() {
        return this;
    }
}
