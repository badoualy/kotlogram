
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readDouble;
import static com.github.badoualy.telegram.tl.StreamUtils.writeDouble;



public class TLInputGeoPoint extends TLAbsInputGeoPoint {
    public static final int CLASS_ID = 0xf3b7acc9;

    public TLInputGeoPoint() {

    }


    public TLInputGeoPoint(        double _lat,         double _lon) {
        this.lat = _lat;
        this.lon = _lon;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected double lat;

    protected double lon;


    public double getLat() {
        return lat;
    }

    public void setLat(double value) {
        this.lat = value;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double value) {
        this.lon = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeDouble(this.lat, stream);
        writeDouble(this.lon, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.lat = readDouble(stream);
        this.lon = readDouble(stream);
    }



    @Override
    public String toString() {
        return "inputGeoPoint#f3b7acc9";
    }

}
