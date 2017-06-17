package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
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
public class TLRequestAccountUpdateProfile extends TLMethod<TLAbsUser> {

    public static final int CONSTRUCTOR_ID = 0x78515775;

    protected int flags;

    protected String firstName;

    protected String lastName;

    protected String about;

    private final String _constructor = "account.updateProfile#78515775";

    public TLRequestAccountUpdateProfile() {
    }

    public TLRequestAccountUpdateProfile(String firstName, String lastName, String about) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.about = about;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsUser deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUser)) {
            throw new IOException(
                    "Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response
                            .getClass().getCanonicalName());
        }
        return (TLAbsUser) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = firstName != null ? (flags | 1) : (flags & ~1);
        flags = lastName != null ? (flags | 2) : (flags & ~2);
        flags = about != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (firstName == null) throwNullFieldException("firstName", flags);
            writeString(firstName, stream);
        }
        if ((flags & 2) != 0) {
            if (lastName == null) throwNullFieldException("lastName", flags);
            writeString(lastName, stream);
        }
        if ((flags & 4) != 0) {
            if (about == null) throwNullFieldException("about", flags);
            writeString(about, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        firstName = (flags & 1) != 0 ? readTLString(stream) : null;
        lastName = (flags & 2) != 0 ? readTLString(stream) : null;
        about = (flags & 4) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (firstName == null) throwNullFieldException("firstName", flags);
            size += computeTLStringSerializedSize(firstName);
        }
        if ((flags & 2) != 0) {
            if (lastName == null) throwNullFieldException("lastName", flags);
            size += computeTLStringSerializedSize(lastName);
        }
        if ((flags & 4) != 0) {
            if (about == null) throwNullFieldException("about", flags);
            size += computeTLStringSerializedSize(about);
        }
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
