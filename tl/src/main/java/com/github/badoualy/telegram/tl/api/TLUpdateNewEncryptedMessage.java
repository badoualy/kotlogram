
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLUpdateNewEncryptedMessage extends TLAbsUpdate {
    public static final int CLASS_ID = 0x12bcbd9a;

    public TLUpdateNewEncryptedMessage() {

    }


    public TLUpdateNewEncryptedMessage(        com.github.badoualy.telegram.tl.api.TLAbsEncryptedMessage _message,         int _qts) {
        this.message = _message;
        this.qts = _qts;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsEncryptedMessage message;

    protected int qts;


    public com.github.badoualy.telegram.tl.api.TLAbsEncryptedMessage getMessage() {
        return message;
    }

    public void setMessage(com.github.badoualy.telegram.tl.api.TLAbsEncryptedMessage value) {
        this.message = value;
    }

    public int getQts() {
        return qts;
    }

    public void setQts(int value) {
        this.qts = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.message, stream);
        writeInt(this.qts, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.message = (com.github.badoualy.telegram.tl.api.TLAbsEncryptedMessage)readTLObject(stream, context);
        this.qts = readInt(stream);
    }



    @Override
    public String toString() {
        return "updateNewEncryptedMessage#12bcbd9a";
    }

}
