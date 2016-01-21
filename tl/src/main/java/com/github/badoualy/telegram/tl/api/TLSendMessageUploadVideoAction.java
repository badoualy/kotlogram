
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;



public class TLSendMessageUploadVideoAction extends TLAbsSendMessageAction {
    public static final int CLASS_ID = 0xe9763aec;

    public TLSendMessageUploadVideoAction() {

    }


    public TLSendMessageUploadVideoAction(        int _progress) {
        this.progress = _progress;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int progress;


    public int getProgress() {
        return progress;
    }

    public void setProgress(int value) {
        this.progress = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.progress, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.progress = readInt(stream);
    }



    @Override
    public String toString() {
        return "sendMessageUploadVideoAction#e9763aec";
    }

}
