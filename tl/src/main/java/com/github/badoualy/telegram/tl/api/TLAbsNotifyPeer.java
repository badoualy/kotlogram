package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLNotifyAll}: notifyAll#74d07c60</li>
 * <li>{@link TLNotifyChats}: notifyChats#c007cec3</li>
 * <li>{@link TLNotifyPeer}: notifyPeer#9fd40bd8</li>
 * <li>{@link TLNotifyUsers}: notifyUsers#b4c83b4c</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsNotifyPeer extends TLObject {

    public TLAbsNotifyPeer() {
    }
}
