
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLNotifyChats extends TLAbsNotifyPeer {
    public static final int CLASS_ID = 0xc007cec3;

    public TLNotifyChats() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "notifyChats#c007cec3";
    }

}
