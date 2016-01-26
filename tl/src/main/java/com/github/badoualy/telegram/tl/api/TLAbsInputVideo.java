package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputVideo extends TLObject {
    public TLAbsInputVideo() {
    }

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLInputVideo getAsInputVideo() {
        return null;
    }

    public static TLInputVideoEmpty newEmpty() {
        return new TLInputVideoEmpty();
    }

    public static TLInputVideo newNotEmpty() {
        return new TLInputVideo();
    }
}
