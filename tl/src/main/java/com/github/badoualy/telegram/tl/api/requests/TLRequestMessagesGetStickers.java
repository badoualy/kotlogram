
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLRequestMessagesGetStickers extends TLMethod<com.github.badoualy.telegram.tl.api.messages.TLAbsStickers> {

    public static final int CLASS_ID = 0xae22e045;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesGetStickers(        String _emoticon,         String _hash) {
        this.emoticon = _emoticon;
        this.hash = _hash;

    }



    public com.github.badoualy.telegram.tl.api.messages.TLAbsStickers deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.messages.TLAbsStickers) {
            return (com.github.badoualy.telegram.tl.api.messages.TLAbsStickers)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.messages.TLAbsStickers, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected String emoticon;

    protected String hash;


    public String getEmoticon() {
        return emoticon;
    }

    public void setEmoticon(String value) {
        this.emoticon = value;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String value) {
        this.hash = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.emoticon, stream);
        writeTLString(this.hash, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.emoticon = readTLString(stream);
        this.hash = readTLString(stream);
    }



    @Override
    public String toString() {
        return "messages.getStickers#ae22e045";
    }

}
