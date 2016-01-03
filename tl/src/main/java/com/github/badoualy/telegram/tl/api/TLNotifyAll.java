
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLNotifyAll extends TLAbsNotifyPeer {
    public static final int CLASS_ID = 0x74d07c60;

    public TLNotifyAll() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "notifyAll#74d07c60";
    }

}
