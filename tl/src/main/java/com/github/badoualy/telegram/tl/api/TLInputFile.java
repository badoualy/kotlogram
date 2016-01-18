
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
