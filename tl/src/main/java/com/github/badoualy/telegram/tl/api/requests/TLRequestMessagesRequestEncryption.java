
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestMessagesRequestEncryption extends TLMethod<com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat> {

    public static final int CLASS_ID = 0xf64daf43;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesRequestEncryption(        com.github.badoualy.telegram.tl.api.TLAbsInputUser _userId,         int _randomId,         TLBytes _gA) {
        this.userId = _userId;
        this.randomId = _randomId;
        this.gA = _gA;

    }



    public com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat) {
            return (com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputUser userId;

    protected int randomId;

    protected TLBytes gA;


    public com.github.badoualy.telegram.tl.api.TLAbsInputUser getUserId() {
        return userId;
    }

    public void setUserId(com.github.badoualy.telegram.tl.api.TLAbsInputUser value) {
        this.userId = value;
    }

    public int getRandomId() {
        return randomId;
    }

    public void setRandomId(int value) {
        this.randomId = value;
    }

    public TLBytes getGA() {
        return gA;
    }

    public void setGA(TLBytes value) {
        this.gA = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.userId, stream);
        writeInt(this.randomId, stream);
        writeTLBytes(this.gA, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = (com.github.badoualy.telegram.tl.api.TLAbsInputUser)readTLObject(stream, context);
        this.randomId = readInt(stream);
        this.gA = readTLBytes(stream, context);
    }



    @Override
    public String toString() {
        return "messages.requestEncryption#f64daf43";
    }

}
