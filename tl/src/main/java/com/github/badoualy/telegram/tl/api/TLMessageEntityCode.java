
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;



public class TLMessageEntityCode extends TLAbsMessageEntity {
    public static final int CLASS_ID = 0x28a20571;

    public TLMessageEntityCode() {

    }


    public TLMessageEntityCode(        int _offset,         int _length) {
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
        return "messageEntityCode#28a20571";
    }

}
