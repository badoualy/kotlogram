
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLPeerNotifySettingsEmpty extends TLAbsPeerNotifySettings {
    public static final int CLASS_ID = 0x70a68512;

    public TLPeerNotifySettingsEmpty() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "peerNotifySettingsEmpty#70a68512";
    }

}
