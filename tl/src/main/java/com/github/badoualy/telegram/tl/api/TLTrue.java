
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLTrue extends TLObject {

    public static final int CLASS_ID = 0x3fedd339;

    public TLTrue() {

    }



    public int getClassId() {
        return CLASS_ID;
    }






    @Override
    public String toString() {
        return "true#3fedd339";
    }

}
