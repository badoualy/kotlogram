package com.github.badoualy.telegram.tl.api.contacts;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLImportedContact;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLImportedContacts extends TLObject {
    public static final int CLASS_ID = 0xad524315;

    protected TLVector<TLImportedContact> imported;

    protected TLVector<Long> retryContacts;

    protected TLVector<TLAbsUser> users;

    public TLImportedContacts() {
    }

    public TLImportedContacts(TLVector<TLImportedContact> imported, TLVector<Long> retryContacts, TLVector<TLAbsUser> users) {
        this.imported = imported;
        this.retryContacts = retryContacts;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(imported, stream);
        writeTLVector(retryContacts, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        imported = readTLVector(stream, context);
        retryContacts = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "contacts.importedContacts#ad524315";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLVector<TLImportedContact> getImported() {
        return imported;
    }

    public void setImported(TLVector<TLImportedContact> imported) {
        this.imported = imported;
    }

    public TLVector<Long> getRetryContacts() {
        return retryContacts;
    }

    public void setRetryContacts(TLVector<Long> retryContacts) {
        this.retryContacts = retryContacts;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
