package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestInvokeAfterMsgs<T extends TLObject> extends TLMethod<T> {
    public static final int CLASS_ID = 0x3dc4b4f0;

    protected TLVector<Long> msgIds;

    protected TLMethod<T> query;

    public TLRequestInvokeAfterMsgs() {
    }

    public TLRequestInvokeAfterMsgs(TLVector<Long> msgIds, TLMethod<T> query) {
        this.msgIds = msgIds;
        this.query = query;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T deserializeResponse(InputStream stream, TLContext context) throws IOException {
        return query.deserializeResponse(stream, context);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(msgIds, stream);
        writeTLMethod(query, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        msgIds = readTLVector(stream, context);
        query = readTLMethod(stream, context);
    }

    @Override
    public String toString() {
        return "invokeAfterMsgs#3dc4b4f0";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLVector<Long> getMsgIds() {
        return msgIds;
    }

    public void setMsgIds(TLVector<Long> msgIds) {
        this.msgIds = msgIds;
    }

    public TLMethod<T> getQuery() {
        return query;
    }

    public void setQuery(TLMethod<T> query) {
        this.query = query;
    }
}
