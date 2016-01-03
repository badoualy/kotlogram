
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLPeerNotifyEventsAll extends TLAbsPeerNotifyEvents {
    public static final int CLASS_ID = 0x6d1ded88;

    public TLPeerNotifyEventsAll() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "peerNotifyEventsAll#6d1ded88";
    }

}
