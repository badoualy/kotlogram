package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputPeerNotifyEventsAll}: inputPeerNotifyEventsAll#e86a2c74</li>
 * <li>{@link TLInputPeerNotifyEventsEmpty}: inputPeerNotifyEventsEmpty#f03064d8</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputPeerNotifyEvents extends TLObject {

    public TLAbsInputPeerNotifyEvents() {
    }

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLInputPeerNotifyEventsAll getAsInputPeerNotifyEventsAll() {
        return null;
    }

    public static TLInputPeerNotifyEventsEmpty newEmpty() {
        return new TLInputPeerNotifyEventsEmpty();
    }

    public static TLInputPeerNotifyEventsAll newNotEmpty() {
        return new TLInputPeerNotifyEventsAll();
    }
}
