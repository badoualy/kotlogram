package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readDouble;
import static com.github.badoualy.telegram.tl.StreamUtils.writeDouble;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLGeoPoint extends TLAbsGeoPoint {

    public static final int CONSTRUCTOR_ID = 0x2049d70c;

    protected double _long;

    protected double lat;

    private final String _constructor = "geoPoint#2049d70c";

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
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        _long = readDouble(stream);
        lat = readDouble(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_DOUBLE;
        size += SIZE_DOUBLE;
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

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLGeoPoint getAsGeoPoint() {
        return this;
    }
}
