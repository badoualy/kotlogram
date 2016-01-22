package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPhotoEmpty extends TLAbsInputPhoto {
    public static final int CLASS_ID = 0x1cd7bf0d;

    public TLInputPhotoEmpty() {
    }

    @Override
    public String toString() {
        return "inputPhotoEmpty#1cd7bf0d";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
