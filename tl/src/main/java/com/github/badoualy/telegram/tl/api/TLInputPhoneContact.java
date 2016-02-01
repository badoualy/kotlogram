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
    public String toString() {
        return "inputPhoneContact#f392b7f4";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
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
