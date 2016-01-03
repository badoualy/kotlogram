
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestMessagesReadEncryptedHistory extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0x7f4b690a;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesReadEncryptedHistory(        com.github.badoualy.telegram.tl.api.TLInputEncryptedChat _peer,         int _maxDate) {
        this.peer = _peer;
        this.maxDate = _maxDate;

    }



    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof TLBool) {
            return (TLBool)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected TLBool, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer;

    protected int maxDate;


    public com.github.badoualy.telegram.tl.api.TLInputEncryptedChat getPeer() {
        return peer;
    }

    public void setPeer(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat value) {
        this.peer = value;
    }

    public int getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(int value) {
        this.maxDate = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeInt(this.maxDate, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLInputEncryptedChat)readTLObject(stream, context);
        this.maxDate = readInt(stream);
    }



    @Override
    public String toString() {
        return "messages.readEncryptedHistory#7f4b690a";
    }

}
