
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;


public class TLRequestMessagesSendBroadcast extends TLMethod<com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessages> {

    public static final int CLASS_ID = 0x41bb0972;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesSendBroadcast(        com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> _contacts,         String _message,         com.github.badoualy.telegram.tl.api.TLAbsInputMedia _media) {
        this.contacts = _contacts;
        this.message = _message;
        this.media = _media;

    }



    public com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessages deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessages) {
            return (com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessages)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessages, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> contacts;

    protected String message;

    protected com.github.badoualy.telegram.tl.api.TLAbsInputMedia media;


    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> getContacts() {
        return contacts;
    }

    public void setContacts(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputUser> value) {
        this.contacts = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsInputMedia getMedia() {
        return media;
    }

    public void setMedia(com.github.badoualy.telegram.tl.api.TLAbsInputMedia value) {
        this.media = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.contacts, stream);
        writeTLString(this.message, stream);
        writeTLObject(this.media, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.contacts = readTLVector(stream, context);
        this.message = readTLString(stream);
        this.media = (com.github.badoualy.telegram.tl.api.TLAbsInputMedia)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "messages.sendBroadcast#41bb0972";
    }

}
