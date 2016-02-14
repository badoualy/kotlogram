package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateUserName extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0xa7332b73;

    protected int userId;

    protected String firstName;

    protected String lastName;

    protected String username;

    private final String _constructor = "updateUserName#a7332b73";

    public TLUpdateUserName() {
    }

    public TLUpdateUserName(int userId, String firstName, String lastName, String username) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(userId, stream);
        writeString(firstName, stream);
        writeString(lastName, stream);
        writeString(username, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        userId = readInt(stream);
        firstName = readTLString(stream);
        lastName = readTLString(stream);
        username = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(firstName);
        size += computeTLStringSerializedSize(lastName);
        size += computeTLStringSerializedSize(username);
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
        if (!(object instanceof TLUpdateUserName)) return false;
        if (object == this) return true;

        TLUpdateUserName o = (TLUpdateUserName) object;

        return userId == o.userId
                && (firstName == o.firstName || (firstName != null && o.firstName != null && firstName.equals(o.firstName)))
                && (lastName == o.lastName || (lastName != null && o.lastName != null && lastName.equals(o.lastName)))
                && (username == o.username || (username != null && o.username != null && username.equals(o.username)));
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
