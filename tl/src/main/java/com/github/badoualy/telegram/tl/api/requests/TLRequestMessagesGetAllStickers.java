
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;


public class TLRequestMessagesGetAllStickers extends TLMethod<com.github.badoualy.telegram.tl.api.messages.TLAbsAllStickers> {

    public static final int CLASS_ID = 0x1c9618b1;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesGetAllStickers(        int _hash) {
        this.hash = _hash;

    }



    public com.github.badoualy.telegram.tl.api.messages.TLAbsAllStickers deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.messages.TLAbsAllStickers) {
            return (com.github.badoualy.telegram.tl.api.messages.TLAbsAllStickers)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.messages.TLAbsAllStickers, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected int hash;


    public int getHash() {
        return hash;
    }

    public void setHash(int value) {
        this.hash = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.hash, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.hash = readInt(stream);
    }



    @Override
    public String toString() {
        return "messages.getAllStickers#1c9618b1";
    }

}
