
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputNotifyAll extends TLAbsInputNotifyPeer {
    public static final int CLASS_ID = 0xa429b886;

    public TLInputNotifyAll() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "inputNotifyAll#a429b886";
    }

}
