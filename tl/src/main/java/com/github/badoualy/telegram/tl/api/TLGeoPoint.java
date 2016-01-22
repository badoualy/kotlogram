package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLGeoPoint extends TLAbsGeoPoint {
    public static final int CLASS_ID = 0x2049d70c;

    protected double _long;

    protected double lat;

    public TLGeoPoint() {
    }

    public TLGeoPoint(double _long, double lat) {
        this._long = _long;
        this.lat = lat;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeDouble(_long, stream);
        writeDouble(lat, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        _long = readDouble(stream);
        lat = readDouble(stream);
    }

    @Override
    public String toString() {
        return "geoPoint#2049d70c";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public double getLong() {
        return _long;
    }

    public void setLong(double _long) {
        this._long = _long;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
