
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLSendMessageUploadAudioAction extends TLAbsSendMessageAction {
    public static final int CLASS_ID = 0xe6ac8a6f;

    public TLSendMessageUploadAudioAction() {

    }



    public int getClassId() {
        return CLASS_ID;
    }







    @Override
    public String toString() {
        return "sendMessageUploadAudioAction#e6ac8a6f";
    }

}
