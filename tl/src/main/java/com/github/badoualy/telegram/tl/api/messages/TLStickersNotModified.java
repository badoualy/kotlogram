package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLStickersNotModified extends TLAbsStickers {
    public static final int CLASS_ID = 0xf1749a22;

    public TLStickersNotModified() {
    }

    @Override
    public String toString() {
        return "messages.stickersNotModified#f1749a22";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
