package com.github.badoualy.telegram.tl.api.payments;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLShippingOption;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLValidatedRequestedInfo extends TLObject {

    public static final int CONSTRUCTOR_ID = 0xd1451883;

    protected int flags;

    protected String id;

    protected TLVector<TLShippingOption> shippingOptions;

    private final String _constructor = "payments.validatedRequestedInfo#d1451883";

    public TLValidatedRequestedInfo() {
    }

    public TLValidatedRequestedInfo(String id, TLVector<TLShippingOption> shippingOptions) {
        this.id = id;
        this.shippingOptions = shippingOptions;
    }

    private void computeFlags() {
        flags = 0;
        flags = id != null ? (flags | 1) : (flags & ~1);
        flags = shippingOptions != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (id == null) throwNullFieldException("id", flags);
            writeString(id, stream);
        }
        if ((flags & 2) != 0) {
            if (shippingOptions == null) throwNullFieldException("shippingOptions", flags);
            writeTLVector(shippingOptions, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        id = (flags & 1) != 0 ? readTLString(stream) : null;
        shippingOptions = (flags & 2) != 0 ? readTLVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (id == null) throwNullFieldException("id", flags);
            size += computeTLStringSerializedSize(id);
        }
        if ((flags & 2) != 0) {
            if (shippingOptions == null) throwNullFieldException("shippingOptions", flags);
            size += shippingOptions.computeSerializedSize();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TLVector<TLShippingOption> getShippingOptions() {
        return shippingOptions;
    }

    public void setShippingOptions(TLVector<TLShippingOption> shippingOptions) {
        this.shippingOptions = shippingOptions;
    }
}
