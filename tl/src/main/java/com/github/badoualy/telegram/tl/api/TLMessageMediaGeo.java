package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageMediaGeo extends TLAbsMessageMedia {
    public static final int CONSTRUCTOR_ID = 0x56e0d474;

    protected TLAbsGeoPoint geo;

    public TLMessageMediaGeo() {
    }

    public TLMessageMediaGeo(TLAbsGeoPoint geo) {
        this.geo = geo;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(geo, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        geo = (com.github.badoualy.telegram.tl.api.TLAbsGeoPoint) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "messageMediaGeo#56e0d474";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLAbsGeoPoint getGeo() {
        return geo;
    }

    public void setGeo(TLAbsGeoPoint geo) {
        this.geo = geo;
    }
}
