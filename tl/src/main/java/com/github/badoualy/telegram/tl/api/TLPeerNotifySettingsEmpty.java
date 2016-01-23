package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPeerNotifySettingsEmpty extends TLAbsPeerNotifySettings {
    public static final int CLASS_ID = 0x70a68512;

    public TLPeerNotifySettingsEmpty() {
    }

    @Override
    public String toString() {
        return "peerNotifySettingsEmpty#70a68512";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
