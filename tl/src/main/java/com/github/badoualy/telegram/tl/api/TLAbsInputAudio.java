package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputAudio extends TLObject {
    public TLAbsInputAudio() {
    }

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLInputAudio getAsInputAudio() {
        return null;
    }

    public static TLInputAudioEmpty newEmpty() {
        return new TLInputAudioEmpty();
    }

    public static TLInputAudio newNotEmpty() {
        return new TLInputAudio();
    }
}
