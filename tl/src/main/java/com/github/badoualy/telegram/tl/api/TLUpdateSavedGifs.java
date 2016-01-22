package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateSavedGifs extends TLAbsUpdate {
    public static final int CLASS_ID = 0x9375341e;

    public TLUpdateSavedGifs() {
    }

    @Override
    public String toString() {
        return "updateSavedGifs#9375341e";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
