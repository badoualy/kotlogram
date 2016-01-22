package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLNearestDc extends TLObject {
    public static final int CLASS_ID = 0x8e1a1775;

    protected String country;

    protected int thisDc;

    protected int nearestDc;

    public TLNearestDc() {
    }

    public TLNearestDc(String country, int thisDc, int nearestDc) {
        this.country = country;
        this.thisDc = thisDc;
        this.nearestDc = nearestDc;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(country, stream);
        writeInt(thisDc, stream);
        writeInt(nearestDc, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        country = readTLString(stream);
        thisDc = readInt(stream);
        nearestDc = readInt(stream);
    }

    @Override
    public String toString() {
        return "nearestDc#8e1a1775";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getThisDc() {
        return thisDc;
    }

    public void setThisDc(int thisDc) {
        this.thisDc = thisDc;
    }

    public int getNearestDc() {
        return nearestDc;
    }

    public void setNearestDc(int nearestDc) {
        this.nearestDc = nearestDc;
    }
}
