package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputAudioEmpty extends TLAbsInputAudio {
    public static final int CLASS_ID = 0xd95adc84;

    public TLInputAudioEmpty() {
    }

    @Override
    public String toString() {
        return "inputAudioEmpty#d95adc84";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public final boolean isEmpty() {
        return true;
    }

    @Override
    public final boolean isNotEmpty() {
        return false;
    }
}
