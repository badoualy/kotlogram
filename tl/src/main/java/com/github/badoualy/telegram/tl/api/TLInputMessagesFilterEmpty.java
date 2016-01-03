
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputMessagesFilterEmpty extends TLAbsMessagesFilter {
    public static final int CLASS_ID = 0x57e2f66c;

    public TLInputMessagesFilterEmpty() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "inputMessagesFilterEmpty#57e2f66c";
    }

}
