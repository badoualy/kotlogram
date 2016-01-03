
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputFile extends TLAbsInputFile {
    public static final int CLASS_ID = 0xf52ff27f;

    public TLInputFile() {

    }


    public TLInputFile(        long _id,         int _parts,         String _name,         String _md5Checksum) {
        this.id = _id;
        this.parts = _parts;
        this.name = _name;
        this.md5Checksum = _md5Checksum;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String md5Checksum;


    public String getMd5Checksum() {
        return md5Checksum;
    }

    public void setMd5Checksum(String value) {
        this.md5Checksum = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.id, stream);
        writeInt(this.parts, stream);
        writeTLString(this.name, stream);
        writeTLString(this.md5Checksum, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readLong(stream);
        this.parts = readInt(stream);
        this.name = readTLString(stream);
        this.md5Checksum = readTLString(stream);
    }



    @Override
    public String toString() {
        return "inputFile#f52ff27f";
    }

}
