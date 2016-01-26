package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readDouble;
import static com.github.badoualy.telegram.tl.StreamUtils.writeDouble;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputGeoPoint extends TLAbsInputGeoPoint {
    public static final int CLASS_ID = 0xf3b7acc9;

    protected double lat;

    protected double _long;

    public TLInputGeoPoint() {
    }

    public TLInputGeoPoint(double lat, double _long) {
        this.lat = lat;
        this._long = _long;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeDouble(lat, stream);
        writeDouble(_long, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        lat = readDouble(stream);
        _long = readDouble(stream);
    }

    @Override
    public String toString() {
        return "inputGeoPoint#f3b7acc9";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLong() {
        return _long;
    }

    public void setLong(double _long) {
        this._long = _long;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLInputGeoPoint getAsInputGeoPoint() {
        return this;
    }
}
