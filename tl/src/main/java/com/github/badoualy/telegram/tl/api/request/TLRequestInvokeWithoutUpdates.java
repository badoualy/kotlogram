package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLMethod;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLMethod;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestInvokeWithoutUpdates<T extends TLObject> extends TLMethod<T> {
    public static final int CLASS_ID = 0xbf9459b7;

    protected TLMethod<T> query;

    public TLRequestInvokeWithoutUpdates() {
    }

    public TLRequestInvokeWithoutUpdates(TLMethod<T> query) {
        this.query = query;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T deserializeResponse(InputStream stream, TLContext context) throws IOException {
        return query.deserializeResponse(stream, context);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLMethod(query, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        query = readTLMethod(stream, context);
    }

    @Override
    public String toString() {
        return "invokeWithoutUpdates#bf9459b7";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLMethod<T> getQuery() {
        return query;
    }

    public void setQuery(TLMethod<T> query) {
        this.query = query;
    }
}
