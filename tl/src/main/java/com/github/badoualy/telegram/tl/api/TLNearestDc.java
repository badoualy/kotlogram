
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLNearestDc extends TLObject {

    public static final int CLASS_ID = 0x8e1a1775;

    public TLNearestDc() {

    }


    public TLNearestDc(        String _country,         int _thisDc,         int _nearestDc) {
        this.country = _country;
        this.thisDc = _thisDc;
        this.nearestDc = _nearestDc;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String country;

    protected int thisDc;

    protected int nearestDc;


    public String getCountry() {
        return country;
    }

    public void setCountry(String value) {
        this.country = value;
    }

    public int getThisDc() {
        return thisDc;
    }

    public void setThisDc(int value) {
        this.thisDc = value;
    }

    public int getNearestDc() {
        return nearestDc;
    }

    public void setNearestDc(int value) {
        this.nearestDc = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.country, stream);
        writeInt(this.thisDc, stream);
        writeInt(this.nearestDc, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.country = readTLString(stream);
        this.thisDc = readInt(stream);
        this.nearestDc = readInt(stream);
    }


    @Override
    public String toString() {
        return "nearestDc#8e1a1775";
    }

}
