
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLSendMessageCancelAction extends TLAbsSendMessageAction {
    public static final int CLASS_ID = 0xfd5ec8f5;

    public TLSendMessageCancelAction() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "sendMessageCancelAction#fd5ec8f5";
    }

}
