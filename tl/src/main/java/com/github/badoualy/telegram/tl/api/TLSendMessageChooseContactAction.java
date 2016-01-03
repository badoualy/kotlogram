
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLSendMessageChooseContactAction extends TLAbsSendMessageAction {
    public static final int CLASS_ID = 0x628cbc6f;

    public TLSendMessageChooseContactAction() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "sendMessageChooseContactAction#628cbc6f";
    }

}
