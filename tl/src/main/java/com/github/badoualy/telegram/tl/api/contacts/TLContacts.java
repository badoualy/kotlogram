package com.github.badoualy.telegram.tl.api.contacts;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLContact;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLContacts extends TLAbsContacts {
    public static final int CLASS_ID = 0x6f8b8cb2;

    protected TLVector<TLContact> contacts;

    protected TLVector<TLAbsUser> users;

    public TLContacts() {
    }

    public TLContacts(TLVector<TLContact> contacts, TLVector<TLAbsUser> users) {
        this.contacts = contacts;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(contacts, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        contacts = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "contacts.contacts#6f8b8cb2";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLVector<TLContact> getContacts() {
        return contacts;
    }

    public void setContacts(TLVector<TLContact> contacts) {
        this.contacts = contacts;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
