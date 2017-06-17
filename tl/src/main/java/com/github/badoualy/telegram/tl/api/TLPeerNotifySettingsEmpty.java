package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPeerNotifySettingsEmpty extends TLAbsPeerNotifySettings {

    public static final int CONSTRUCTOR_ID = 0x70a68512;

    private final String _constructor = "peerNotifySettingsEmpty#70a68512";

    public TLPeerNotifySettingsEmpty() {
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
        return true;
    }

    @Override
    public final boolean isNotEmpty() {
        return false;
    }
}
