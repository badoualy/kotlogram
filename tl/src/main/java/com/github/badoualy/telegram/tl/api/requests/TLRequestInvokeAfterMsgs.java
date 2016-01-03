
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestInvokeAfterMsgs extends TLMethod<TLObject> {

    public static final int CLASS_ID = 0x3dc4b4f0;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestInvokeAfterMsgs(        com.github.badoualy.telegram.tl.core.TLLongVector _msgIds,         TLMethod _query) {
        this.msgIds = _msgIds;
        this.query = _query;

    }



    public TLObject deserializeResponse(InputStream stream, TLContext context) throws IOException {

        return (TLObject) query.deserializeResponse(stream, context);

    }
        


    protected com.github.badoualy.telegram.tl.core.TLLongVector msgIds;

    protected TLMethod query;


    public com.github.badoualy.telegram.tl.core.TLLongVector getMsgIds() {
        return msgIds;
    }

    public void setMsgIds(com.github.badoualy.telegram.tl.core.TLLongVector value) {
        this.msgIds = value;
    }

    public TLMethod getQuery() {
        return query;
    }

    public void setQuery(TLMethod value) {
        this.query = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.msgIds, stream);
        writeTLMethod(this.query, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.msgIds = readTLLongVector(stream, context);
        this.query = readTLMethod(stream, context);
    }



    @Override
    public String toString() {
        return "invokeAfterMsgs#3dc4b4f0";
    }

}
