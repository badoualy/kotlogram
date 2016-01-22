package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

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
}
