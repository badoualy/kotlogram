
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputNotifyUsers extends TLAbsInputNotifyPeer {
    public static final int CLASS_ID = 0x193b4417;

    public TLInputNotifyUsers() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "inputNotifyUsers#193b4417";
    }

}
