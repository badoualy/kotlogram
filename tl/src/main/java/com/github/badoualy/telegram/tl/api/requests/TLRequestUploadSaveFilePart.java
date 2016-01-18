
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;


public class TLRequestUploadSaveFilePart extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0xb304a621;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestUploadSaveFilePart(        long _fileId,         int _filePart,         TLBytes _bytes) {
        this.fileId = _fileId;
        this.filePart = _filePart;
        this.bytes = _bytes;

    }



    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof TLBool) {
            return (TLBool)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected TLBool, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected long fileId;

    protected int filePart;

    protected TLBytes bytes;


    public long getFileId() {
        return fileId;
    }

    public void setFileId(long value) {
        this.fileId = value;
    }

    public int getFilePart() {
        return filePart;
    }

    public void setFilePart(int value) {
        this.filePart = value;
    }

    public TLBytes getBytes() {
        return bytes;
    }

    public void setBytes(TLBytes value) {
        this.bytes = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.fileId, stream);
        writeInt(this.filePart, stream);
        writeTLBytes(this.bytes, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.fileId = readLong(stream);
        this.filePart = readInt(stream);
        this.bytes = readTLBytes(stream, context);
    }



    @Override
    public String toString() {
        return "upload.saveFilePart#b304a621";
    }

}
