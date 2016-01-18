
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



public class TLInputFileBig extends TLAbsInputFile {
    public static final int CLASS_ID = 0xfa4f0bb5;

    public TLInputFileBig() {

    }


    public TLInputFileBig(        long _id,         int _parts,         String _name) {
        this.id = _id;
        this.parts = _parts;
        this.name = _name;

    }


    public int getClassId() {
        return CLASS_ID;
    }




    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.id, stream);
        writeInt(this.parts, stream);
        writeTLString(this.name, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readLong(stream);
        this.parts = readInt(stream);
        this.name = readTLString(stream);
    }



    @Override
    public String toString() {
        return "inputFileBig#fa4f0bb5";
    }

}
