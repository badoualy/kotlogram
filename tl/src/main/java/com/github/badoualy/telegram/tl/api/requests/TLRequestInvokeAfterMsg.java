
package com.github.badoualy.telegram.tl.api.requests;

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


public class TLRequestInvokeAfterMsg extends TLMethod<TLObject> {

    public static final int CLASS_ID = 0xcb9f372d;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestInvokeAfterMsg(        long _msgId,         TLMethod _query) {
        this.msgId = _msgId;
        this.query = _query;

    }



    public TLObject deserializeResponse(InputStream stream, TLContext context) throws IOException {

        return (TLObject) query.deserializeResponse(stream, context);

    }
        


    protected long msgId;

    protected TLMethod query;


    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long value) {
        this.msgId = value;
    }

    public TLMethod getQuery() {
        return query;
    }

    public void setQuery(TLMethod value) {
        this.query = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.msgId, stream);
        writeTLMethod(this.query, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.msgId = readLong(stream);
        this.query = readTLMethod(stream, context);
    }



    @Override
    public String toString() {
        return "invokeAfterMsg#cb9f372d";
    }

}
