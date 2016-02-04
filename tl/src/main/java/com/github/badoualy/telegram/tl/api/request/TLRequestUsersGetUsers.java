package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestUsersGetUsers extends TLMethod<TLVector<TLAbsUser>> {
    public static final int CONSTRUCTOR_ID = 0xd91a548;

    protected TLVector<? extends TLAbsInputUser> id;

    public TLRequestUsersGetUsers() {
    }

    public TLRequestUsersGetUsers(TLVector<? extends TLAbsInputUser> id) {
        this.id = id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLVector<TLAbsUser> deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLVector)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLVector<TLAbsUser>) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(id, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "users.getUsers#d91a548";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLVector<? extends TLAbsInputUser> getId() {
        return id;
    }

    public void setId(TLVector<? extends TLAbsInputUser> id) {
        this.id = id;
    }
}
