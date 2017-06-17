package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMediaVenue extends TLAbsInputMedia {

    public static final int CONSTRUCTOR_ID = 0x2827a81a;

    protected TLAbsInputGeoPoint geoPoint;

    protected String title;

    protected String address;

    protected String provider;

    protected String venueId;

    private final String _constructor = "inputMediaVenue#2827a81a";

    public TLInputMediaVenue() {
    }

    public TLInputMediaVenue(TLAbsInputGeoPoint geoPoint, String title, String address, String provider, String venueId) {
        this.geoPoint = geoPoint;
        this.title = title;
        this.address = address;
        this.provider = provider;
        this.venueId = venueId;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(geoPoint, stream);
        writeString(title, stream);
        writeString(address, stream);
        writeString(provider, stream);
        writeString(venueId, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        geoPoint = readTLObject(stream, context, TLAbsInputGeoPoint.class, -1);
        title = readTLString(stream);
        address = readTLString(stream);
        provider = readTLString(stream);
        venueId = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += geoPoint.computeSerializedSize();
        size += computeTLStringSerializedSize(title);
        size += computeTLStringSerializedSize(address);
        size += computeTLStringSerializedSize(provider);
        size += computeTLStringSerializedSize(venueId);
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

    public TLAbsInputGeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(TLAbsInputGeoPoint geoPoint) {
        this.geoPoint = geoPoint;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }
}
