
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLMessageMediaEmpty extends TLAbsMessageMedia {
    public static final int CLASS_ID = 0x3ded6320;

    public TLMessageMediaEmpty() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "messageMediaEmpty#3ded6320";
    }

}
