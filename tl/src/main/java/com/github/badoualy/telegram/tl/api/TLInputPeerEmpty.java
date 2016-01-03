
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputPeerEmpty extends TLAbsInputPeer {
    public static final int CLASS_ID = 0x7f3b18ea;

    public TLInputPeerEmpty() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "inputPeerEmpty#7f3b18ea";
    }

}
