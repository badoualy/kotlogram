
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLChatPhotoEmpty extends TLAbsChatPhoto {
    public static final int CLASS_ID = 0x37c1011c;

    public TLChatPhotoEmpty() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "chatPhotoEmpty#37c1011c";
    }

}
