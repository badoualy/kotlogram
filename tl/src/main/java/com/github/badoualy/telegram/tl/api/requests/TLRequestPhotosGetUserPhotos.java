
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;


public class TLRequestPhotosGetUserPhotos extends TLMethod<com.github.badoualy.telegram.tl.api.photos.TLAbsPhotos> {

    public static final int CLASS_ID = 0xb7ee553c;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestPhotosGetUserPhotos(        com.github.badoualy.telegram.tl.api.TLAbsInputUser _userId,         int _offset,         int _maxId,         int _limit) {
        this.userId = _userId;
        this.offset = _offset;
        this.maxId = _maxId;
        this.limit = _limit;

    }



    public com.github.badoualy.telegram.tl.api.photos.TLAbsPhotos deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.photos.TLAbsPhotos) {
            return (com.github.badoualy.telegram.tl.api.photos.TLAbsPhotos)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.photos.TLAbsPhotos, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputUser userId;

    protected int offset;

    protected int maxId;

    protected int limit;


    public com.github.badoualy.telegram.tl.api.TLAbsInputUser getUserId() {
        return userId;
    }

    public void setUserId(com.github.badoualy.telegram.tl.api.TLAbsInputUser value) {
        this.userId = value;
    }

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

        writeTLObject(this.userId, stream);
        writeInt(this.offset, stream);
        writeInt(this.maxId, stream);
        writeInt(this.limit, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = (com.github.badoualy.telegram.tl.api.TLAbsInputUser)readTLObject(stream, context);
        this.offset = readInt(stream);
        this.maxId = readInt(stream);
        this.limit = readInt(stream);
    }



    @Override
    public String toString() {
        return "photos.getUserPhotos#b7ee553c";
    }

}
