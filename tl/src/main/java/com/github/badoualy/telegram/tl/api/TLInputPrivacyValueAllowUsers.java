package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLInputPrivacyValueAllowUsers extends TLAbsInputPrivacyRule {
    public static final int CONSTRUCTOR_ID = 0x131cc67f;

    protected TLVector<? extends TLAbsInputUser> users;

    public TLInputPrivacyValueAllowUsers() {
    }

    public TLInputPrivacyValueAllowUsers(TLVector<? extends TLAbsInputUser> users) {
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += users.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "inputPrivacyValueAllowUsers#131cc67f";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputPrivacyValueAllowUsers)) return false;
        if (object == this) return true;

        TLInputPrivacyValueAllowUsers o = (TLInputPrivacyValueAllowUsers) object;

        return (users == o.users || (users != null && o.users != null && users.equals(o.users)));
    }

    public TLVector<? extends TLAbsInputUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<? extends TLAbsInputUser> users) {
        this.users = users;
    }
}
