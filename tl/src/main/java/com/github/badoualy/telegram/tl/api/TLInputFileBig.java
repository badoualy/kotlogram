
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



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
