
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLInputMediaVenue extends TLAbsInputMedia {
    public static final int CLASS_ID = 0x2827a81a;

    public TLInputMediaVenue() {

    }


    public TLInputMediaVenue(        com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint _geoPoint,         String _title,         String _address,         String _provider,         String _venueId) {
        this.geoPoint = _geoPoint;
        this.title = _title;
        this.address = _address;
        this.provider = _provider;
        this.venueId = _venueId;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint geoPoint;

    protected String title;

    protected String address;

    protected String provider;

    protected String venueId;


    public com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint value) {
        this.geoPoint = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String value) {
        this.address = value;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String value) {
        this.provider = value;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String value) {
        this.venueId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.geoPoint, stream);
        writeTLString(this.title, stream);
        writeTLString(this.address, stream);
        writeTLString(this.provider, stream);
        writeTLString(this.venueId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.geoPoint = (com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint)readTLObject(stream, context);
        this.title = readTLString(stream);
        this.address = readTLString(stream);
        this.provider = readTLString(stream);
        this.venueId = readTLString(stream);
    }



    @Override
    public String toString() {
        return "inputMediaVenue#2827a81a";
    }

}
