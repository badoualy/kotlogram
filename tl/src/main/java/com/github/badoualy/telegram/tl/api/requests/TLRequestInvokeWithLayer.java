
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLMethod;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLMethod;


public class TLRequestInvokeWithLayer<T extends TLObject> extends TLMethod<T> {

    public static final int CLASS_ID = 0xda9b0d0d;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestInvokeWithLayer(        int _layer,         TLMethod<T> _query) {
        this.layer = _layer;
        this.query = _query;

    }



    public T deserializeResponse(InputStream stream, TLContext context) throws IOException {

        return (T) query.deserializeResponse(stream, context);

    }
        


    protected int layer;

    protected TLMethod<T> query;


    public int getLayer() {
        return layer;
    }

    public void setLayer(int value) {
        this.layer = value;
    }

    public TLMethod<T> getQuery() {
        return query;
    }

    public void setQuery(TLMethod<T> value) {
        this.query = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.layer, stream);
        writeTLMethod(this.query, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.layer = readInt(stream);
        this.query = readTLMethod(stream, context);
    }



    @Override
    public String toString() {
        return "invokeWithLayer#da9b0d0d";
    }

}
