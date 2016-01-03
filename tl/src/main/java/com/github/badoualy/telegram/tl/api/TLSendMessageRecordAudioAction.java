
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLSendMessageRecordAudioAction extends TLAbsSendMessageAction {
    public static final int CLASS_ID = 0xd52f73f7;

    public TLSendMessageRecordAudioAction() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "sendMessageRecordAudioAction#d52f73f7";
    }

}
