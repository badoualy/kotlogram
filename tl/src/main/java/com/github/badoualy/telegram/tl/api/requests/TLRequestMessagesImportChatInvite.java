
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


public class TLRequestMessagesImportChatInvite extends TLMethod<com.github.badoualy.telegram.tl.api.TLAbsUpdates> {

    public static final int CLASS_ID = 0x6c50051c;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesImportChatInvite(        String _hash) {
        this.hash = _hash;

    }



    public com.github.badoualy.telegram.tl.api.TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.TLAbsUpdates) {
            return (com.github.badoualy.telegram.tl.api.TLAbsUpdates)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.TLAbsUpdates, got: " + res.getClass().getCanonicalName());
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
        return "messages.importChatInvite#6c50051c";
    }

}
