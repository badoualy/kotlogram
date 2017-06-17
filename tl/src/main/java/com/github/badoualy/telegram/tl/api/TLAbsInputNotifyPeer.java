package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputNotifyAll}: inputNotifyAll#a429b886</li>
 * <li>{@link TLInputNotifyChats}: inputNotifyChats#4a95e84e</li>
 * <li>{@link TLInputNotifyPeer}: inputNotifyPeer#b8bc5b0c</li>
 * <li>{@link TLInputNotifyUsers}: inputNotifyUsers#193b4417</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputNotifyPeer extends TLObject {

    public TLAbsInputNotifyPeer() {
    }
}
