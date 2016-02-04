package com.github.badoualy.telegram.tl.api.contacts;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLContactSuggested;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLSuggested extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x5649dcc5;

    protected TLVector<? extends TLContactSuggested> results;

    protected TLVector<? extends TLAbsUser> users;

    public TLSuggested() {
    }

    public TLSuggested(TLVector<? extends TLContactSuggested> results, TLVector<? extends TLAbsUser> users) {
        this.results = results;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(results, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        results = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "contacts.suggested#5649dcc5";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLVector<? extends TLContactSuggested> getResults() {
        return results;
    }

    public void setResults(TLVector<? extends TLContactSuggested> results) {
        this.results = results;
    }

    public TLVector<? extends TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<? extends TLAbsUser> users) {
        this.users = users;
    }
}
