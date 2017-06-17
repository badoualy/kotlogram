package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPeerNotifyEventsAll extends TLAbsInputPeerNotifyEvents {

    public static final int CONSTRUCTOR_ID = 0xe86a2c74;

    private final String _constructor = "inputPeerNotifyEventsAll#e86a2c74";

    public TLInputPeerNotifyEventsAll() {
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
    public final TLInputPeerNotifyEventsAll getAsInputPeerNotifyEventsAll() {
        return this;
    }
}
