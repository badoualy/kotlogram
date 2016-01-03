
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLMessageMediaGeo extends TLAbsMessageMedia {
    public static final int CLASS_ID = 0x56e0d474;

    public TLMessageMediaGeo() {

    }


    public TLMessageMediaGeo(        com.github.badoualy.telegram.tl.api.TLAbsGeoPoint _geo) {
        this.geo = _geo;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsGeoPoint geo;


    public com.github.badoualy.telegram.tl.api.TLAbsGeoPoint getGeo() {
        return geo;
    }

    public void setGeo(com.github.badoualy.telegram.tl.api.TLAbsGeoPoint value) {
        this.geo = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.geo, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.geo = (com.github.badoualy.telegram.tl.api.TLAbsGeoPoint)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "messageMediaGeo#56e0d474";
    }

}
