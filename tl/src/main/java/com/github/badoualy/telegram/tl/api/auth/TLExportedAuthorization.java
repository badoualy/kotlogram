
package com.github.badoualy.telegram.tl.api.auth;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLExportedAuthorization extends TLObject {

    public static final int CLASS_ID = 0xdf969c2d;

    public TLExportedAuthorization() {

    }


    public TLExportedAuthorization(        int _id,         TLBytes _bytes) {
        this.id = _id;
        this.bytes = _bytes;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int id;

    protected TLBytes bytes;


    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public TLBytes getBytes() {
        return bytes;
    }

    public void setBytes(TLBytes value) {
        this.bytes = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeTLBytes(this.bytes, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.bytes = readTLBytes(stream, context);
    }


    @Override
    public String toString() {
        return "auth.exportedAuthorization#df969c2d";
    }

}
