
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputNotifyChats extends TLAbsInputNotifyPeer {
    public static final int CLASS_ID = 0x4a95e84e;

    public TLInputNotifyChats() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "inputNotifyChats#4a95e84e";
    }

}
