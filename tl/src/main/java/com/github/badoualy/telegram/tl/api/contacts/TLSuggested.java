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
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLSuggested extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x5649dcc5;

    protected TLVector<TLContactSuggested> results;

    protected TLVector<TLAbsUser> users;

    private final String _constructor = "contacts.suggested#5649dcc5";

    public TLSuggested() {
    }

    public TLSuggested(TLVector<TLContactSuggested> results, TLVector<TLAbsUser> users) {
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
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += results.computeSerializedSize();
        size += users.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLSuggested)) return false;
        if (object == this) return true;

        TLSuggested o = (TLSuggested) object;

        return (results == o.results || (results != null && o.results != null && results.equals(o.results)))
                && (users == o.users || (users != null && o.users != null && users.equals(o.users)));
    }

    public TLVector<TLContactSuggested> getResults() {
        return results;
    }

    public void setResults(TLVector<TLContactSuggested> results) {
        this.results = results;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
