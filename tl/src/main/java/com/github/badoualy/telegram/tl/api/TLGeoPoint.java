
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLGeoPoint extends TLAbsGeoPoint {
    public static final int CLASS_ID = 0x2049d70c;

    public TLGeoPoint() {

    }


    public TLGeoPoint(        double _lon,         double _lat) {
        this.lon = _lon;
        this.lat = _lat;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected double lon;

    protected double lat;


    public double getLon() {
        return lon;
    }

    public void setLon(double value) {
        this.lon = value;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double value) {
        this.lat = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeDouble(this.lon, stream);
        writeDouble(this.lat, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.lon = readDouble(stream);
        this.lat = readDouble(stream);
    }



    @Override
    public String toString() {
        return "geoPoint#2049d70c";
    }

}
