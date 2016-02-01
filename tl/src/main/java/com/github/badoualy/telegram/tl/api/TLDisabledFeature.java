package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLDisabledFeature extends TLObject {
    public static final int CONSTRUCTOR_ID = 0xae636f24;

    protected String feature;

    protected String description;

    public TLDisabledFeature() {
    }

    public TLDisabledFeature(String feature, String description) {
        this.feature = feature;
        this.description = description;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(feature, stream);
        writeTLString(description, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        feature = readTLString(stream);
        description = readTLString(stream);
    }

    @Override
    public String toString() {
        return "disabledFeature#ae636f24";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
