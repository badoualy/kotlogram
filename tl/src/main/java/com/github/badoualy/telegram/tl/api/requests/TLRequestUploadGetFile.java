
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


public class TLRequestUploadGetFile extends TLMethod<com.github.badoualy.telegram.tl.api.upload.TLFile> {

    public static final int CLASS_ID = 0xe3a6cfb5;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestUploadGetFile(        com.github.badoualy.telegram.tl.api.TLAbsInputFileLocation _location,         int _offset,         int _limit) {
        this.location = _location;
        this.offset = _offset;
        this.limit = _limit;

    }



    public com.github.badoualy.telegram.tl.api.upload.TLFile deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.upload.TLFile) {
            return (com.github.badoualy.telegram.tl.api.upload.TLFile)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.upload.TLFile, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputFileLocation location;

    protected int offset;

    protected int limit;


    public com.github.badoualy.telegram.tl.api.TLAbsInputFileLocation getLocation() {
        return location;
    }

    public void setLocation(com.github.badoualy.telegram.tl.api.TLAbsInputFileLocation value) {
        this.location = value;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int value) {
        this.offset = value;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int value) {
        this.limit = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.location, stream);
        writeInt(this.offset, stream);
        writeInt(this.limit, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.location = (com.github.badoualy.telegram.tl.api.TLAbsInputFileLocation)readTLObject(stream, context);
        this.offset = readInt(stream);
        this.limit = readInt(stream);
    }



    @Override
    public String toString() {
        return "upload.getFile#e3a6cfb5";
    }

}
