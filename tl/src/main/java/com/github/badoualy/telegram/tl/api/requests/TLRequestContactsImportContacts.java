
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;


public class TLRequestContactsImportContacts extends TLMethod<com.github.badoualy.telegram.tl.api.contacts.TLImportedContacts> {

    public static final int CLASS_ID = 0xda30b32d;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestContactsImportContacts(        com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLInputContact> _contacts,         boolean _replace) {
        this.contacts = _contacts;
        this.replace = _replace;

    }



    public com.github.badoualy.telegram.tl.api.contacts.TLImportedContacts deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.contacts.TLImportedContacts) {
            return (com.github.badoualy.telegram.tl.api.contacts.TLImportedContacts)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.contacts.TLImportedContacts, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLInputContact> contacts;

    protected boolean replace;


    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLInputContact> getContacts() {
        return contacts;
    }

    public void setContacts(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLInputContact> value) {
        this.contacts = value;
    }

    public boolean getReplace() {
        return replace;
    }

    public void setReplace(boolean value) {
        this.replace = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.contacts, stream);
        writeTLBool(this.replace, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.contacts = readTLVector(stream, context);
        this.replace = readTLBool(stream);
    }



    @Override
    public String toString() {
        return "contacts.importContacts#da30b32d";
    }

}
