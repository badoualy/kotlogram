
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLSendMessageUploadDocumentAction extends TLAbsSendMessageAction {
    public static final int CLASS_ID = 0x8faee98e;

    public TLSendMessageUploadDocumentAction() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "sendMessageUploadDocumentAction#8faee98e";
    }

}
