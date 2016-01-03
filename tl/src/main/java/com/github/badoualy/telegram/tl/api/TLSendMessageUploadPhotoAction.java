
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLSendMessageUploadPhotoAction extends TLAbsSendMessageAction {
    public static final int CLASS_ID = 0x990a3c1a;

    public TLSendMessageUploadPhotoAction() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "sendMessageUploadPhotoAction#990a3c1a";
    }

}
