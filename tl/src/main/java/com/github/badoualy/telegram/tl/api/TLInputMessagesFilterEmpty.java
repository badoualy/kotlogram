package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMessagesFilterEmpty extends TLAbsMessagesFilter {
    public static final int CLASS_ID = 0x57e2f66c;

    public TLInputMessagesFilterEmpty() {
    }

    @Override
    public String toString() {
        return "inputMessagesFilterEmpty#57e2f66c";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
