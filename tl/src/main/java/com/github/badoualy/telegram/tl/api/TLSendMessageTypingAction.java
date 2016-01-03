
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLSendMessageTypingAction extends TLAbsSendMessageAction {
    public static final int CLASS_ID = 0x16bf744e;

    public TLSendMessageTypingAction() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "sendMessageTypingAction#16bf744e";
    }

}
