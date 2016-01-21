
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;



public class TLMessageEntityUnknown extends TLAbsMessageEntity {
    public static final int CLASS_ID = 0xbb92ba95;

    public TLMessageEntityUnknown() {

    }


    public TLMessageEntityUnknown(        int _offset,         int _length) {
        this.offset = _offset;
        this.length = _length;

    }


    public int getClassId() {
        return CLASS_ID;
    }




    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.offset, stream);
        writeInt(this.length, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.offset = readInt(stream);
        this.length = readInt(stream);
    }



    @Override
    public String toString() {
        return "messageEntityUnknown#bb92ba95";
    }

}
