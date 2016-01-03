
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputChatPhotoEmpty extends TLAbsInputChatPhoto {
    public static final int CLASS_ID = 0x1ca48f57;

    public TLInputChatPhotoEmpty() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "inputChatPhotoEmpty#1ca48f57";
    }

}
