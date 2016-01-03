
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLUserProfilePhotoEmpty extends TLAbsUserProfilePhoto {
    public static final int CLASS_ID = 0x4f11bae1;

    public TLUserProfilePhotoEmpty() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "userProfilePhotoEmpty#4f11bae1";
    }

}
