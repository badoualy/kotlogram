package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateNewAuthorization extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x8f06529a;

    protected long authKeyId;

    protected int date;

    protected String device;

    protected String location;

    private final String _constructor = "updateNewAuthorization#8f06529a";

    public TLUpdateNewAuthorization() {
    }

    public TLUpdateNewAuthorization(long authKeyId, int date, String device, String location) {
        this.authKeyId = authKeyId;
        this.date = date;
        this.device = device;
        this.location = location;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(authKeyId, stream);
        writeInt(date, stream);
        writeString(device, stream);
        writeString(location, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        authKeyId = readLong(stream);
        date = readInt(stream);
        device = readTLString(stream);
        location = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(device);
        size += computeTLStringSerializedSize(location);
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
        if (!(object instanceof TLUpdateNewAuthorization)) return false;
        if (object == this) return true;

        TLUpdateNewAuthorization o = (TLUpdateNewAuthorization) object;

        return authKeyId == o.authKeyId
                && date == o.date
                && (device == o.device || (device != null && o.device != null && device.equals(o.device)))
                && (location == o.location || (location != null && o.location != null && location.equals(o.location)));
    }

    public long getAuthKeyId() {
        return authKeyId;
    }

    public void setAuthKeyId(long authKeyId) {
        this.authKeyId = authKeyId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
