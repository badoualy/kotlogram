
package com.github.badoualy.telegram.tl.api.contacts;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLImportedContacts extends TLObject {

    public static final int CLASS_ID = 0xad524315;

    public TLImportedContacts() {

    }


    public TLImportedContacts(        com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLImportedContact> _imported,         com.github.badoualy.telegram.tl.core.TLLongVector _retryContacts,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> _users) {
        this.imported = _imported;
        this.retryContacts = _retryContacts;
        this.users = _users;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLImportedContact> imported;

    protected com.github.badoualy.telegram.tl.core.TLLongVector retryContacts;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> users;


    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLImportedContact> getImported() {
        return imported;
    }

    public void setImported(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLImportedContact> value) {
        this.imported = value;
    }

    public com.github.badoualy.telegram.tl.core.TLLongVector getRetryContacts() {
        return retryContacts;
    }

    public void setRetryContacts(com.github.badoualy.telegram.tl.core.TLLongVector value) {
        this.retryContacts = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> value) {
        this.users = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.imported, stream);
        writeTLVector(this.retryContacts, stream);
        writeTLVector(this.users, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.imported = readTLVector(stream, context);
        this.retryContacts = readTLLongVector(stream, context);
        this.users = readTLVector(stream, context);
    }


    @Override
    public String toString() {
        return "contacts.importedContacts#ad524315";
    }

}
