
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputMessagesFilterPhotoVideoDocuments extends TLAbsMessagesFilter {
    public static final int CLASS_ID = 0xd95e73bb;

    public TLInputMessagesFilterPhotoVideoDocuments() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "inputMessagesFilterPhotoVideoDocuments#d95e73bb";
    }

}
