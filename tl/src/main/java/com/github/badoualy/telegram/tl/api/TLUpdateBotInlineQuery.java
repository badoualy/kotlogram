
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLUpdateBotInlineQuery extends TLAbsUpdate {
    public static final int CLASS_ID = 0xc01eea08;

    public TLUpdateBotInlineQuery() {

    }


    public TLUpdateBotInlineQuery(        long _queryId,         int _userId,         String _query,         String _offset) {
        this.queryId = _queryId;
        this.userId = _userId;
        this.query = _query;
        this.offset = _offset;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected long queryId;

    protected int userId;

    protected String query;

    protected String offset;


    public long getQueryId() {
        return queryId;
    }

    public void setQueryId(long value) {
        this.queryId = value;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String value) {
        this.query = value;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String value) {
        this.offset = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.queryId, stream);
        writeInt(this.userId, stream);
        writeTLString(this.query, stream);
        writeTLString(this.offset, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.queryId = readLong(stream);
        this.userId = readInt(stream);
        this.query = readTLString(stream);
        this.offset = readTLString(stream);
    }



    @Override
    public String toString() {
        return "updateBotInlineQuery#c01eea08";
    }

}
