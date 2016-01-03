
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestAuthImportAuthorization extends TLMethod<com.github.badoualy.telegram.tl.api.auth.TLAuthorization> {

    public static final int CLASS_ID = 0xe3ef9613;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAuthImportAuthorization(        int _id,         TLBytes _bytes) {
        this.id = _id;
        this.bytes = _bytes;

    }



    public com.github.badoualy.telegram.tl.api.auth.TLAuthorization deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.auth.TLAuthorization) {
            return (com.github.badoualy.telegram.tl.api.auth.TLAuthorization)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.auth.TLAuthorization, got: " + res.getClass().getCanonicalName());
        }

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
        return "auth.importAuthorization#e3ef9613";
    }

}
