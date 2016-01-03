
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLPeerNotifyEventsEmpty extends TLAbsPeerNotifyEvents {
    public static final int CLASS_ID = 0xadd53cb3;

    public TLPeerNotifyEventsEmpty() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "peerNotifyEventsEmpty#add53cb3";
    }

}
