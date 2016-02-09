package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPhoneContact extends TLObject {
    public static final int CONSTRUCTOR_ID = 0xf392b7f4;

    protected long clientId;

    protected String phone;

    protected String firstName;

    protected String lastName;

    public TLInputPhoneContact() {
    }

    public TLInputPhoneContact(long clientId, String phone, String firstName, String lastName) {
        this.clientId = clientId;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(clientId, stream);
        writeString(phone, stream);
        writeString(firstName, stream);
        writeString(lastName, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        clientId = readLong(stream);
        phone = readTLString(stream);
        firstName = readTLString(stream);
        lastName = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(phone);
        size += computeTLStringSerializedSize(firstName);
        size += computeTLStringSerializedSize(lastName);
        return size;
    }

    @Override
    public String toString() {
        return "inputPhoneContact#f392b7f4";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputPhoneContact)) return false;
        if (object == this) return true;

        TLInputPhoneContact o = (TLInputPhoneContact) object;

        return clientId == o.clientId
                && (phone == o.phone || (phone != null && o.phone != null && phone.equals(o.phone)))
                && (firstName == o.firstName || (firstName != null && o.firstName != null && firstName.equals(o.firstName)))
                && (lastName == o.lastName || (lastName != null && o.lastName != null && lastName.equals(o.lastName)));
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
}
