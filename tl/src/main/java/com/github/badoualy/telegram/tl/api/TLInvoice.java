package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLInvoice extends TLObject {

    public static final int CONSTRUCTOR_ID = 0xc30aa358;

    protected int flags;

    protected boolean test;

    protected boolean nameRequested;

    protected boolean phoneRequested;

    protected boolean emailRequested;

    protected boolean shippingAddressRequested;

    protected boolean flexible;

    protected String currency;

    protected TLVector<TLLabeledPrice> prices;

    private final String _constructor = "invoice#c30aa358";

    public TLInvoice() {
    }

    public TLInvoice(boolean test, boolean nameRequested, boolean phoneRequested, boolean emailRequested, boolean shippingAddressRequested, boolean flexible, String currency, TLVector<TLLabeledPrice> prices) {
        this.test = test;
        this.nameRequested = nameRequested;
        this.phoneRequested = phoneRequested;
        this.emailRequested = emailRequested;
        this.shippingAddressRequested = shippingAddressRequested;
        this.flexible = flexible;
        this.currency = currency;
        this.prices = prices;
    }

    private void computeFlags() {
        flags = 0;
        flags = test ? (flags | 1) : (flags & ~1);
        flags = nameRequested ? (flags | 2) : (flags & ~2);
        flags = phoneRequested ? (flags | 4) : (flags & ~4);
        flags = emailRequested ? (flags | 8) : (flags & ~8);
        flags = shippingAddressRequested ? (flags | 16) : (flags & ~16);
        flags = flexible ? (flags | 32) : (flags & ~32);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(currency, stream);
        writeTLVector(prices, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        test = (flags & 1) != 0;
        nameRequested = (flags & 2) != 0;
        phoneRequested = (flags & 4) != 0;
        emailRequested = (flags & 8) != 0;
        shippingAddressRequested = (flags & 16) != 0;
        flexible = (flags & 32) != 0;
        currency = readTLString(stream);
        prices = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(currency);
        size += prices.computeSerializedSize();
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

    public boolean getTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public boolean getNameRequested() {
        return nameRequested;
    }

    public void setNameRequested(boolean nameRequested) {
        this.nameRequested = nameRequested;
    }

    public boolean getPhoneRequested() {
        return phoneRequested;
    }

    public void setPhoneRequested(boolean phoneRequested) {
        this.phoneRequested = phoneRequested;
    }

    public boolean getEmailRequested() {
        return emailRequested;
    }

    public void setEmailRequested(boolean emailRequested) {
        this.emailRequested = emailRequested;
    }

    public boolean getShippingAddressRequested() {
        return shippingAddressRequested;
    }

    public void setShippingAddressRequested(boolean shippingAddressRequested) {
        this.shippingAddressRequested = shippingAddressRequested;
    }

    public boolean getFlexible() {
        return flexible;
    }

    public void setFlexible(boolean flexible) {
        this.flexible = flexible;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public TLVector<TLLabeledPrice> getPrices() {
        return prices;
    }

    public void setPrices(TLVector<TLLabeledPrice> prices) {
        this.prices = prices;
    }
}
