package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestInvokeWithLayer<T extends TLObject> extends TLMethod<T> {
    public static final int CLASS_ID = 0xda9b0d0d;

    protected int layer;

    protected TLMethod<T> query;

    public TLRequestInvokeWithLayer() {
    }

    public TLRequestInvokeWithLayer(int layer, TLMethod<T> query) {
        this.layer = layer;
        this.query = query;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T deserializeResponse(InputStream stream, TLContext context) throws IOException {
        return query.deserializeResponse(stream, context);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(layer, stream);
        writeTLMethod(query, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        layer = readInt(stream);
        query = readTLMethod(stream, context);
    }

    @Override
    public String toString() {
        return "invokeWithLayer#da9b0d0d";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public TLMethod<T> getQuery() {
        return query;
    }

    public void setQuery(TLMethod<T> query) {
        this.query = query;
    }
}
