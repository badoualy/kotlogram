
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestMessagesGetDialogs extends TLMethod<com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs> {

    public static final int CLASS_ID = 0xeccf1df6;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesGetDialogs(        int _offset,         int _maxId,         int _limit) {
        this.offset = _offset;
        this.maxId = _maxId;
        this.limit = _limit;

    }



    public com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs) {
            return (com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected int offset;

    protected int maxId;

    protected int limit;


    public int getOffset() {
        return offset;
    }

    public void setOffset(int value) {
        this.offset = value;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int value) {
        this.maxId = value;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int value) {
        this.limit = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.offset, stream);
        writeInt(this.maxId, stream);
        writeInt(this.limit, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.offset = readInt(stream);
        this.maxId = readInt(stream);
        this.limit = readInt(stream);
    }



    @Override
    public String toString() {
        return "messages.getDialogs#eccf1df6";
    }

}
