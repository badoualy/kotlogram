
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestUploadSaveBigFilePart extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0xde7b673d;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestUploadSaveBigFilePart(        long _fileId,         int _filePart,         int _fileTotalParts,         TLBytes _bytes) {
        this.fileId = _fileId;
        this.filePart = _filePart;
        this.fileTotalParts = _fileTotalParts;
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

    protected int fileTotalParts;

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

    public int getFileTotalParts() {
        return fileTotalParts;
    }

    public void setFileTotalParts(int value) {
        this.fileTotalParts = value;
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
        writeInt(this.fileTotalParts, stream);
        writeTLBytes(this.bytes, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.fileId = readLong(stream);
        this.filePart = readInt(stream);
        this.fileTotalParts = readInt(stream);
        this.bytes = readTLBytes(stream, context);
    }



    @Override
    public String toString() {
        return "upload.saveBigFilePart#de7b673d";
    }

}
