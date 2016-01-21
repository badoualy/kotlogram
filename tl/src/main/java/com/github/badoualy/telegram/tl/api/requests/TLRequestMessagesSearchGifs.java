
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLRequestMessagesSearchGifs extends TLMethod<com.github.badoualy.telegram.tl.api.messages.TLFoundGifs> {

    public static final int CLASS_ID = 0xbf9a776b;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesSearchGifs(        String _q,         int _offset) {
        this.q = _q;
        this.offset = _offset;

    }



    public com.github.badoualy.telegram.tl.api.messages.TLFoundGifs deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.messages.TLFoundGifs) {
            return (com.github.badoualy.telegram.tl.api.messages.TLFoundGifs)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.messages.TLFoundGifs, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected String q;

    protected int offset;


    public String getQ() {
        return q;
    }

    public void setQ(String value) {
        this.q = value;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int value) {
        this.offset = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.q, stream);
        writeInt(this.offset, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.q = readTLString(stream);
        this.offset = readInt(stream);
    }



    @Override
    public String toString() {
        return "messages.searchGifs#bf9a776b";
    }

}
