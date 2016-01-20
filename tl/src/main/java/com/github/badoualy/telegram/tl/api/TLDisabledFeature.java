
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLDisabledFeature extends TLObject {

    public static final int CLASS_ID = 0xae636f24;

    public TLDisabledFeature() {

    }


    public TLDisabledFeature(        String _feature,         String _description) {
        this.feature = _feature;
        this.description = _description;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String feature;

    protected String description;


    public String getFeature() {
        return feature;
    }

    public void setFeature(String value) {
        this.feature = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.feature, stream);
        writeTLString(this.description, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.feature = readTLString(stream);
        this.description = readTLString(stream);
    }


    @Override
    public String toString() {
        return "disabledFeature#ae636f24";
    }

}
