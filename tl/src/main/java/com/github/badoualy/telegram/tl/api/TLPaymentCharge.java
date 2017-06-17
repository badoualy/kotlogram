package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPaymentCharge extends TLObject {

    public static final int CONSTRUCTOR_ID = 0xea02c27e;

    protected String id;

    protected String providerChargeId;

    private final String _constructor = "paymentCharge#ea02c27e";

    public TLPaymentCharge() {
    }

    public TLPaymentCharge(String id, String providerChargeId) {
        this.id = id;
        this.providerChargeId = providerChargeId;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(id, stream);
        writeString(providerChargeId, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readTLString(stream);
        providerChargeId = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(id);
        size += computeTLStringSerializedSize(providerChargeId);
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

    public String getProviderChargeId() {
        return providerChargeId;
    }

    public void setProviderChargeId(String providerChargeId) {
        this.providerChargeId = providerChargeId;
    }
}
