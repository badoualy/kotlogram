
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputPeerSelf extends TLAbsInputPeer {
    public static final int CLASS_ID = 0x7da07ec9;

    public TLInputPeerSelf() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "inputPeerSelf#7da07ec9";
    }

}
