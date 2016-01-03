
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputPhotoEmpty extends TLAbsInputPhoto {
    public static final int CLASS_ID = 0x1cd7bf0d;

    public TLInputPhotoEmpty() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "inputPhotoEmpty#1cd7bf0d";
    }

}
