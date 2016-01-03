
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputMessagesFilterPhotoVideo extends TLAbsMessagesFilter {
    public static final int CLASS_ID = 0x56e9f0e4;

    public TLInputMessagesFilterPhotoVideo() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "inputMessagesFilterPhotoVideo#56e9f0e4";
    }

}
