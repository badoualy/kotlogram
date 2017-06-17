package com.github.badoualy.telegram.tl.api.payments;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLInvoice;
import com.github.badoualy.telegram.tl.api.TLPaymentRequestedInfo;
import com.github.badoualy.telegram.tl.api.TLShippingOption;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPaymentReceipt extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x500911e1;

    protected int flags;

    protected int date;

    protected int botId;

    protected TLInvoice invoice;

    protected int providerId;

    protected TLPaymentRequestedInfo info;

    protected TLShippingOption shipping;

    protected String currency;

    protected long totalAmount;

    protected String credentialsTitle;

    protected TLVector<TLAbsUser> users;

    private final String _constructor = "payments.paymentReceipt#500911e1";

    public TLPaymentReceipt() {
    }

    public TLPaymentReceipt(int date, int botId, TLInvoice invoice, int providerId, TLPaymentRequestedInfo info, TLShippingOption shipping, String currency, long totalAmount, String credentialsTitle, TLVector<TLAbsUser> users) {
        this.date = date;
        this.botId = botId;
        this.invoice = invoice;
        this.providerId = providerId;
        this.info = info;
        this.shipping = shipping;
        this.currency = currency;
        this.totalAmount = totalAmount;
        this.credentialsTitle = credentialsTitle;
        this.users = users;
    }

    private void computeFlags() {
        flags = 0;
        flags = info != null ? (flags | 1) : (flags & ~1);
        flags = shipping != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(date, stream);
        writeInt(botId, stream);
        writeTLObject(invoice, stream);
        writeInt(providerId, stream);
        if ((flags & 1) != 0) {
            if (info == null) throwNullFieldException("info", flags);
            writeTLObject(info, stream);
        }
        if ((flags & 2) != 0) {
            if (shipping == null) throwNullFieldException("shipping", flags);
            writeTLObject(shipping, stream);
        }
        writeString(currency, stream);
        writeLong(totalAmount, stream);
        writeString(credentialsTitle, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        date = readInt(stream);
        botId = readInt(stream);
        invoice = readTLObject(stream, context, TLInvoice.class, TLInvoice.CONSTRUCTOR_ID);
        providerId = readInt(stream);
        info = (flags & 1) != 0 ? readTLObject(stream, context, TLPaymentRequestedInfo.class,
                                               TLPaymentRequestedInfo.CONSTRUCTOR_ID) : null;
        shipping = (flags & 2) != 0 ? readTLObject(stream, context, TLShippingOption.class,
                                                   TLShippingOption.CONSTRUCTOR_ID) : null;
        currency = readTLString(stream);
        totalAmount = readLong(stream);
        credentialsTitle = readTLString(stream);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += invoice.computeSerializedSize();
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (info == null) throwNullFieldException("info", flags);
            size += info.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (shipping == null) throwNullFieldException("shipping", flags);
            size += shipping.computeSerializedSize();
        }
        size += computeTLStringSerializedSize(currency);
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(credentialsTitle);
        size += users.computeSerializedSize();
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getBotId() {
        return botId;
    }

    public void setBotId(int botId) {
        this.botId = botId;
    }

    public TLInvoice getInvoice() {
        return invoice;
    }

    public void setInvoice(TLInvoice invoice) {
        this.invoice = invoice;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public TLPaymentRequestedInfo getInfo() {
        return info;
    }

    public void setInfo(TLPaymentRequestedInfo info) {
        this.info = info;
    }

    public TLShippingOption getShipping() {
        return shipping;
    }

    public void setShipping(TLShippingOption shipping) {
        this.shipping = shipping;
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

    public String getCredentialsTitle() {
        return credentialsTitle;
    }

    public void setCredentialsTitle(String credentialsTitle) {
        this.credentialsTitle = credentialsTitle;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
