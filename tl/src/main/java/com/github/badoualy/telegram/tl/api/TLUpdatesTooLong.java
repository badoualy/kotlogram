
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLUpdatesTooLong extends TLAbsUpdates {
    public static final int CLASS_ID = 0xe317af7e;

    public TLUpdatesTooLong() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "updatesTooLong#e317af7e";
    }

}
