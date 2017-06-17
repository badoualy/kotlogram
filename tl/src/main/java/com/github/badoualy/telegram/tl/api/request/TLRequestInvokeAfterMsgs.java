package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLLongVector;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLLongVector;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLMethod;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLMethod;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestInvokeAfterMsgs<T extends TLObject> extends TLMethod<T> {

    public static final int CONSTRUCTOR_ID = 0x3dc4b4f0;

    protected TLLongVector msgIds;

    protected TLMethod<T> query;

    private final String _constructor = "invokeAfterMsgs#3dc4b4f0";

    public TLRequestInvokeAfterMsgs() {
    }

    public TLRequestInvokeAfterMsgs(TLLongVector msgIds, TLMethod<T> query) {
        this.msgIds = msgIds;
        this.query = query;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public T deserializeResponse(InputStream stream, TLContext context) throws IOException {
        return query.deserializeResponse(stream, context);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(msgIds, stream);
        writeTLMethod(query, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        msgIds = readTLLongVector(stream, context);
        query = readTLMethod(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += msgIds.computeSerializedSize();
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

    public TLLongVector getMsgIds() {
        return msgIds;
    }

    public void setMsgIds(TLLongVector msgIds) {
        this.msgIds = msgIds;
    }

    public TLMethod<T> getQuery() {
        return query;
    }

    public void setQuery(TLMethod<T> query) {
        this.query = query;
    }
}
