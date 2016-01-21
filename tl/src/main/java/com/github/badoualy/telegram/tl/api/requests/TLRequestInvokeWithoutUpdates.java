
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLMethod;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLMethod;


public class TLRequestInvokeWithoutUpdates extends TLMethod<TLObject> {

    public static final int CLASS_ID = 0xbf9459b7;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestInvokeWithoutUpdates(        TLMethod _query) {
        this.query = _query;

    }



    public TLObject deserializeResponse(InputStream stream, TLContext context) throws IOException {

        return (TLObject) query.deserializeResponse(stream, context);

    }
        


    protected TLMethod query;


    public TLMethod getQuery() {
        return query;
    }

    public void setQuery(TLMethod value) {
        this.query = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLMethod(this.query, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.query = readTLMethod(stream, context);
    }



    @Override
    public String toString() {
        return "invokeWithoutUpdates#bf9459b7";
    }

}
