package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUserProfilePhotoEmpty extends TLAbsUserProfilePhoto {
    public static final int CLASS_ID = 0x4f11bae1;

    public TLUserProfilePhotoEmpty() {
    }

    @Override
    public String toString() {
        return "userProfilePhotoEmpty#4f11bae1";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
