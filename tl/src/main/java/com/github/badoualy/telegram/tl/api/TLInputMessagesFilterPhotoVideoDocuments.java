package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMessagesFilterPhotoVideoDocuments extends TLAbsMessagesFilter {
    public static final int CLASS_ID = 0xd95e73bb;

    public TLInputMessagesFilterPhotoVideoDocuments() {
    }

    @Override
    public String toString() {
        return "inputMessagesFilterPhotoVideoDocuments#d95e73bb";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
