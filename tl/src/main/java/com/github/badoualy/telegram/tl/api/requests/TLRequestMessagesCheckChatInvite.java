
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


public class TLRequestMessagesCheckChatInvite extends TLMethod<com.github.badoualy.telegram.tl.api.TLAbsChatInvite> {

    public static final int CLASS_ID = 0x3eadb1bb;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesCheckChatInvite(        String _hash) {
        this.hash = _hash;

    }



    public com.github.badoualy.telegram.tl.api.TLAbsChatInvite deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.TLAbsChatInvite) {
            return (com.github.badoualy.telegram.tl.api.TLAbsChatInvite)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.TLAbsChatInvite, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected String hash;


    public String getHash() {
        return hash;
    }

    public void setHash(String value) {
        this.hash = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.hash, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.hash = readTLString(stream);
    }



    @Override
    public String toString() {
        return "messages.checkChatInvite#3eadb1bb";
    }

}
