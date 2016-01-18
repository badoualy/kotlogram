
package com.github.badoualy.telegram.tl.api.upload;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;


public class TLFile extends TLObject {

    public static final int CLASS_ID = 0x96a18d5;

    public TLFile() {

    }


    public TLFile(        com.github.badoualy.telegram.tl.api.storage.TLAbsFileType _type,         int _mtime,         TLBytes _bytes) {
        this.type = _type;
        this.mtime = _mtime;
        this.bytes = _bytes;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.storage.TLAbsFileType type;

    protected int mtime;

    protected TLBytes bytes;


    public com.github.badoualy.telegram.tl.api.storage.TLAbsFileType getType() {
        return type;
    }

    public void setType(com.github.badoualy.telegram.tl.api.storage.TLAbsFileType value) {
        this.type = value;
    }

    public int getMtime() {
        return mtime;
    }

    public void setMtime(int value) {
        this.mtime = value;
    }

    public TLBytes getBytes() {
        return bytes;
    }

    public void setBytes(TLBytes value) {
        this.bytes = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.type, stream);
        writeInt(this.mtime, stream);
        writeTLBytes(this.bytes, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.type = (com.github.badoualy.telegram.tl.api.storage.TLAbsFileType)readTLObject(stream, context);
        this.mtime = readInt(stream);
        this.bytes = readTLBytes(stream, context);
    }


    @Override
    public String toString() {
        return "upload.file#96a18d5";
    }

}
