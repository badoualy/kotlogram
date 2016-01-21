
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


public class TLRequestMessagesGetWebPagePreview extends TLMethod<com.github.badoualy.telegram.tl.api.TLAbsMessageMedia> {

    public static final int CLASS_ID = 0x25223e24;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesGetWebPagePreview(        String _message) {
        this.message = _message;

    }



    public com.github.badoualy.telegram.tl.api.TLAbsMessageMedia deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.TLAbsMessageMedia) {
            return (com.github.badoualy.telegram.tl.api.TLAbsMessageMedia)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.TLAbsMessageMedia, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.message, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.message = readTLString(stream);
    }



    @Override
    public String toString() {
        return "messages.getWebPagePreview#25223e24";
    }

}
