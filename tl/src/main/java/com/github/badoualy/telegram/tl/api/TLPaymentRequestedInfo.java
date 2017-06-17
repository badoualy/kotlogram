package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPaymentRequestedInfo extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x909c3f94;

    protected int flags;

    protected String name;

    protected String phone;

    protected String email;

    protected TLPostAddress shippingAddress;

    private final String _constructor = "paymentRequestedInfo#909c3f94";

    public TLPaymentRequestedInfo() {
    }

    public TLPaymentRequestedInfo(String name, String phone, String email, TLPostAddress shippingAddress) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.shippingAddress = shippingAddress;
    }

    private void computeFlags() {
        flags = 0;
        flags = name != null ? (flags | 1) : (flags & ~1);
        flags = phone != null ? (flags | 2) : (flags & ~2);
        flags = email != null ? (flags | 4) : (flags & ~4);
        flags = shippingAddress != null ? (flags | 8) : (flags & ~8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (name == null) throwNullFieldException("name", flags);
            writeString(name, stream);
        }
        if ((flags & 2) != 0) {
            if (phone == null) throwNullFieldException("phone", flags);
            writeString(phone, stream);
        }
        if ((flags & 4) != 0) {
            if (email == null) throwNullFieldException("email", flags);
            writeString(email, stream);
        }
        if ((flags & 8) != 0) {
            if (shippingAddress == null) throwNullFieldException("shippingAddress", flags);
            writeTLObject(shippingAddress, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        name = (flags & 1) != 0 ? readTLString(stream) : null;
        phone = (flags & 2) != 0 ? readTLString(stream) : null;
        email = (flags & 4) != 0 ? readTLString(stream) : null;
        shippingAddress = (flags & 8) != 0 ? readTLObject(stream, context, TLPostAddress.class,
                                                          TLPostAddress.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (name == null) throwNullFieldException("name", flags);
            size += computeTLStringSerializedSize(name);
        }
        if ((flags & 2) != 0) {
            if (phone == null) throwNullFieldException("phone", flags);
            size += computeTLStringSerializedSize(phone);
        }
        if ((flags & 4) != 0) {
            if (email == null) throwNullFieldException("email", flags);
            size += computeTLStringSerializedSize(email);
        }
        if ((flags & 8) != 0) {
            if (shippingAddress == null) throwNullFieldException("shippingAddress", flags);
            size += shippingAddress.computeSerializedSize();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TLPostAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(TLPostAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
