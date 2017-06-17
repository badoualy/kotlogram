package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLPeerNotifyEventsAll}: peerNotifyEventsAll#6d1ded88</li>
 * <li>{@link TLPeerNotifyEventsEmpty}: peerNotifyEventsEmpty#add53cb3</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsPeerNotifyEvents extends TLObject {

    public TLAbsPeerNotifyEvents() {
    }

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLPeerNotifyEventsAll getAsPeerNotifyEventsAll() {
        return null;
    }
}
