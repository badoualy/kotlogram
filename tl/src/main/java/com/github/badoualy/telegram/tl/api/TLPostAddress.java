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
public class TLPostAddress extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x1e8caaeb;

    protected String streetLine1;

    protected String streetLine2;

    protected String city;

    protected String state;

    protected String countryIso2;

    protected String postCode;

    private final String _constructor = "postAddress#1e8caaeb";

    public TLPostAddress() {
    }

    public TLPostAddress(String streetLine1, String streetLine2, String city, String state, String countryIso2, String postCode) {
        this.streetLine1 = streetLine1;
        this.streetLine2 = streetLine2;
        this.city = city;
        this.state = state;
        this.countryIso2 = countryIso2;
        this.postCode = postCode;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(streetLine1, stream);
        writeString(streetLine2, stream);
        writeString(city, stream);
        writeString(state, stream);
        writeString(countryIso2, stream);
        writeString(postCode, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        streetLine1 = readTLString(stream);
        streetLine2 = readTLString(stream);
        city = readTLString(stream);
        state = readTLString(stream);
        countryIso2 = readTLString(stream);
        postCode = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(streetLine1);
        size += computeTLStringSerializedSize(streetLine2);
        size += computeTLStringSerializedSize(city);
        size += computeTLStringSerializedSize(state);
        size += computeTLStringSerializedSize(countryIso2);
        size += computeTLStringSerializedSize(postCode);
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

    public String getStreetLine1() {
        return streetLine1;
    }

    public void setStreetLine1(String streetLine1) {
        this.streetLine1 = streetLine1;
    }

    public String getStreetLine2() {
        return streetLine2;
    }

    public void setStreetLine2(String streetLine2) {
        this.streetLine2 = streetLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountryIso2() {
        return countryIso2;
    }

    public void setCountryIso2(String countryIso2) {
        this.countryIso2 = countryIso2;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
