
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


public class TLRequestAuthImportBotAuthorization extends TLMethod<com.github.badoualy.telegram.tl.api.auth.TLAuthorization> {

    public static final int CLASS_ID = 0x67a3ff2c;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAuthImportBotAuthorization(        int _flags,         int _apiId,         String _apiHash,         String _botAuthToken) {
        this.flags = _flags;
        this.apiId = _apiId;
        this.apiHash = _apiHash;
        this.botAuthToken = _botAuthToken;

    }



    public com.github.badoualy.telegram.tl.api.auth.TLAuthorization deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.auth.TLAuthorization) {
            return (com.github.badoualy.telegram.tl.api.auth.TLAuthorization)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.auth.TLAuthorization, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected int flags;

    protected int apiId;

    protected String apiHash;

    protected String botAuthToken;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int value) {
        this.apiId = value;
    }

    public String getApiHash() {
        return apiHash;
    }

    public void setApiHash(String value) {
        this.apiHash = value;
    }

    public String getBotAuthToken() {
        return botAuthToken;
    }

    public void setBotAuthToken(String value) {
        this.botAuthToken = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.flags, stream);
        writeInt(this.apiId, stream);
        writeTLString(this.apiHash, stream);
        writeTLString(this.botAuthToken, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.apiId = readInt(stream);
        this.apiHash = readTLString(stream);
        this.botAuthToken = readTLString(stream);
    }



    @Override
    public String toString() {
        return "auth.importBotAuthorization#67a3ff2c";
    }

}
