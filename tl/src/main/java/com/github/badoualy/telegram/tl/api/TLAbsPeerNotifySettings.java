package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLPeerNotifySettings}: peerNotifySettings#9acda4c0</li>
 * <li>{@link TLPeerNotifySettingsEmpty}: peerNotifySettingsEmpty#70a68512</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsPeerNotifySettings extends TLObject {

    public TLAbsPeerNotifySettings() {
    }

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLPeerNotifySettings getAsPeerNotifySettings() {
        return null;
    }
}
