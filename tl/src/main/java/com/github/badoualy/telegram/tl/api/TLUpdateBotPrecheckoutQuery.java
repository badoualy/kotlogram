package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateBotPrecheckoutQuery extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x5d2f3aa9;

    protected int flags;

    protected long queryId;

    protected int userId;

    protected TLBytes payload;

    protected TLPaymentRequestedInfo info;

    protected String shippingOptionId;

    protected String currency;

    protected long totalAmount;

    private final String _constructor = "updateBotPrecheckoutQuery#5d2f3aa9";

    public TLUpdateBotPrecheckoutQuery() {
    }

    public TLUpdateBotPrecheckoutQuery(long queryId, int userId, TLBytes payload, TLPaymentRequestedInfo info, String shippingOptionId, String currency, long totalAmount) {
        this.queryId = queryId;
        this.userId = userId;
        this.payload = payload;
        this.info = info;
        this.shippingOptionId = shippingOptionId;
        this.currency = currency;
        this.totalAmount = totalAmount;
    }

    private void computeFlags() {
        flags = 0;
        flags = info != null ? (flags | 1) : (flags & ~1);
        flags = shippingOptionId != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(queryId, stream);
        writeInt(userId, stream);
        writeTLBytes(payload, stream);
        if ((flags & 1) != 0) {
            if (info == null) throwNullFieldException("info", flags);
            writeTLObject(info, stream);
        }
        if ((flags & 2) != 0) {
            if (shippingOptionId == null) throwNullFieldException("shippingOptionId", flags);
            writeString(shippingOptionId, stream);
        }
        writeString(currency, stream);
        writeLong(totalAmount, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        queryId = readLong(stream);
        userId = readInt(stream);
        payload = readTLBytes(stream, context);
        info = (flags & 1) != 0 ? readTLObject(stream, context, TLPaymentRequestedInfo.class,
                                               TLPaymentRequestedInfo.CONSTRUCTOR_ID) : null;
        shippingOptionId = (flags & 2) != 0 ? readTLString(stream) : null;
        currency = readTLString(stream);
        totalAmount = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += computeTLBytesSerializedSize(payload);
        if ((flags & 1) != 0) {
            if (info == null) throwNullFieldException("info", flags);
            size += info.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (shippingOptionId == null) throwNullFieldException("shippingOptionId", flags);
            size += computeTLStringSerializedSize(shippingOptionId);
        }
        size += computeTLStringSerializedSize(currency);
        size += SIZE_INT64;
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

    public long getQueryId() {
        return queryId;
    }

    public void setQueryId(long queryId) {
        this.queryId = queryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public TLBytes getPayload() {
        return payload;
    }

    public void setPayload(TLBytes payload) {
        this.payload = payload;
    }

    public TLPaymentRequestedInfo getInfo() {
        return info;
    }

    public void setInfo(TLPaymentRequestedInfo info) {
        this.info = info;
    }

    public String getShippingOptionId() {
        return shippingOptionId;
    }

    public void setShippingOptionId(String shippingOptionId) {
        this.shippingOptionId = shippingOptionId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }
}
