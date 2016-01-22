package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMessagesFilterPhotoVideo extends TLAbsMessagesFilter {
    public static final int CLASS_ID = 0x56e9f0e4;

    public TLInputMessagesFilterPhotoVideo() {
    }

    @Override
    public String toString() {
        return "inputMessagesFilterPhotoVideo#56e9f0e4";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
