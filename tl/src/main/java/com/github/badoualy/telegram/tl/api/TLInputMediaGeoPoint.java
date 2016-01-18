
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLInputMediaGeoPoint extends TLAbsInputMedia {
    public static final int CLASS_ID = 0xf9c44144;

    public TLInputMediaGeoPoint() {

    }


    public TLInputMediaGeoPoint(        com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint _geoPoint) {
        this.geoPoint = _geoPoint;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint geoPoint;


    public com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint value) {
        this.geoPoint = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.geoPoint, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.geoPoint = (com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "inputMediaGeoPoint#f9c44144";
    }

}
