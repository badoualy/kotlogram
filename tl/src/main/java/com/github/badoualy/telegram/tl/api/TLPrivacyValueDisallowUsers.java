package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLPrivacyValueDisallowUsers extends TLAbsPrivacyRule {
    public static final int CLASS_ID = 0xc7f49b7;

    protected TLVector<Integer> users;

    public TLPrivacyValueDisallowUsers() {
    }

    public TLPrivacyValueDisallowUsers(TLVector<Integer> users) {
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
    public String toString() {
        return "privacyValueDisallowUsers#c7f49b7";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLVector<Integer> getUsers() {
        return users;
    }

    public void setUsers(TLVector<Integer> users) {
        this.users = users;
    }
}
