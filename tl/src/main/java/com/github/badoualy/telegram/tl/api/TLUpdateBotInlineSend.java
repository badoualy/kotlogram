
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLUpdateBotInlineSend extends TLAbsUpdate {
    public static final int CLASS_ID = 0xf69e113;

    public TLUpdateBotInlineSend() {

    }


    public TLUpdateBotInlineSend(        int _userId,         String _query,         String _id) {
        this.userId = _userId;
        this.query = _query;
        this.id = _id;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;

    protected String query;

    protected String id;


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

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
        writeTLString(this.query, stream);
        writeTLString(this.id, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
        this.query = readTLString(stream);
        this.id = readTLString(stream);
    }



    @Override
    public String toString() {
        return "updateBotInlineSend#f69e113";
    }

}
