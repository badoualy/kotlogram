
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLNotifyUsers extends TLAbsNotifyPeer {
    public static final int CLASS_ID = 0xb4c83b4c;

    public TLNotifyUsers() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "notifyUsers#b4c83b4c";
    }

}
