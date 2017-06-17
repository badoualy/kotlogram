package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLPeerChannel}: peerChannel#bddde532</li>
 * <li>{@link TLPeerChat}: peerChat#bad0e5bb</li>
 * <li>{@link TLPeerUser}: peerUser#9db1bc6d</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsPeer extends TLObject {

    public TLAbsPeer() {
    }
}
