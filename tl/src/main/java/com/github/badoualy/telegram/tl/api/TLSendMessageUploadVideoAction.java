
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLSendMessageUploadVideoAction extends TLAbsSendMessageAction {
    public static final int CLASS_ID = 0x92042ff7;

    public TLSendMessageUploadVideoAction() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "sendMessageUploadVideoAction#92042ff7";
    }

}
