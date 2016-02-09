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
public class TLMessageMediaVenue extends TLAbsMessageMedia {
    public static final int CONSTRUCTOR_ID = 0x7912b71f;

    protected TLAbsGeoPoint geo;

    protected String title;

    protected String address;

    protected String provider;

    protected String venueId;

    public TLMessageMediaVenue() {
    }

    public TLMessageMediaVenue(TLAbsGeoPoint geo, String title, String address, String provider, String venueId) {
        this.geo = geo;
        this.title = title;
        this.address = address;
        this.provider = provider;
        this.venueId = venueId;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(geo, stream);
        writeString(title, stream);
        writeString(address, stream);
        writeString(provider, stream);
        writeString(venueId, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        geo = readTLObject(stream, context, TLAbsGeoPoint.class, -1);
        title = readTLString(stream);
        address = readTLString(stream);
        provider = readTLString(stream);
        venueId = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += geo.computeSerializedSize();
        size += computeTLStringSerializedSize(title);
        size += computeTLStringSerializedSize(address);
        size += computeTLStringSerializedSize(provider);
        size += computeTLStringSerializedSize(venueId);
        return size;
    }

    @Override
    public String toString() {
        return "messageMediaVenue#7912b71f";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLMessageMediaVenue)) return false;
        if (object == this) return true;

        TLMessageMediaVenue o = (TLMessageMediaVenue) object;

        return (geo == o.geo || (geo != null && o.geo != null && geo.equals(o.geo)))
                && (title == o.title || (title != null && o.title != null && title.equals(o.title)))
                && (address == o.address || (address != null && o.address != null && address.equals(o.address)))
                && (provider == o.provider || (provider != null && o.provider != null && provider.equals(o.provider)))
                && (venueId == o.venueId || (venueId != null && o.venueId != null && venueId.equals(o.venueId)));
    }

    public TLAbsGeoPoint getGeo() {
        return geo;
    }

    public void setGeo(TLAbsGeoPoint geo) {
        this.geo = geo;
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
