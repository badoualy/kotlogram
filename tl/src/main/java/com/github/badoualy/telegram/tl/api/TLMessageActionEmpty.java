
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLMessageActionEmpty extends TLAbsMessageAction {
    public static final int CLASS_ID = 0xb6aef7b0;

    public TLMessageActionEmpty() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "messageActionEmpty#b6aef7b0";
    }

}
