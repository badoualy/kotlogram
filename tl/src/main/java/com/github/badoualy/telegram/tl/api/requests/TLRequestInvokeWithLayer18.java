
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestInvokeWithLayer18<T extends TLObject> extends TLMethod<T> {

    public static final int CLASS_ID = 0x1c900537;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestInvokeWithLayer18(        TLMethod<T> _query) {
        this.query = _query;

    }



    public T deserializeResponse(InputStream stream, TLContext context) throws IOException {

        return (T) query.deserializeResponse(stream, context);

    }
        


    protected TLMethod<T> query;


    public TLMethod<T> getQuery() {
        return query;
    }

    public void setQuery(TLMethod<T> value) {
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
        return "invokeWithLayer18#1c900537";
    }

}
