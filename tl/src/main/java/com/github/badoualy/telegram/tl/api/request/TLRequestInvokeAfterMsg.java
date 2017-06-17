package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLMethod;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLMethod;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestInvokeAfterMsg<T extends TLObject> extends TLMethod<T> {

    public static final int CONSTRUCTOR_ID = 0xcb9f372d;

    protected long msgId;

    protected TLMethod<T> query;

    private final String _constructor = "invokeAfterMsg#cb9f372d";

    public TLRequestInvokeAfterMsg() {
    }

    public TLRequestInvokeAfterMsg(long msgId, TLMethod<T> query) {
        this.msgId = msgId;
        this.query = query;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public T deserializeResponse(InputStream stream, TLContext context) throws IOException {
        return query.deserializeResponse(stream, context);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(msgId, stream);
        writeTLMethod(query, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        msgId = readLong(stream);
        query = readTLMethod(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += query.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

    public TLMethod<T> getQuery() {
        return query;
    }

    public void setQuery(TLMethod<T> query) {
        this.query = query;
    }
}
