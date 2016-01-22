package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageMediaUnsupported extends TLAbsMessageMedia {
    public static final int CLASS_ID = 0x9f84f49e;

    public TLMessageMediaUnsupported() {
    }

    @Override
    public String toString() {
        return "messageMediaUnsupported#9f84f49e";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
