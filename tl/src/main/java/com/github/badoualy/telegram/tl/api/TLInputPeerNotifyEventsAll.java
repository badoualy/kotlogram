
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputPeerNotifyEventsAll extends TLAbsInputPeerNotifyEvents {
    public static final int CLASS_ID = 0xe86a2c74;

    public TLInputPeerNotifyEventsAll() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "inputPeerNotifyEventsAll#e86a2c74";
    }

}
