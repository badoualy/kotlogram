
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLMessageActionChatDeletePhoto extends TLAbsMessageAction {
    public static final int CLASS_ID = 0x95e3fbef;

    public TLMessageActionChatDeletePhoto() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "messageActionChatDeletePhoto#95e3fbef";
    }

}
