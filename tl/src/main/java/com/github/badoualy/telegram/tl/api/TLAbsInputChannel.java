package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputChannel}: inputChannel#afeb712e</li>
 * <li>{@link TLInputChannelEmpty}: inputChannelEmpty#ee8c1e86</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputChannel extends TLObject {

    public TLAbsInputChannel() {
    }

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLInputChannel getAsInputChannel() {
        return null;
    }

    public static TLInputChannelEmpty newEmpty() {
        return new TLInputChannelEmpty();
    }

    public static TLInputChannel newNotEmpty() {
        return new TLInputChannel();
    }
}
