
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



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
