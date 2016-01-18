
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;



public class TLDocumentEmpty extends TLAbsDocument {
    public static final int CLASS_ID = 0x36f8c871;

    public TLDocumentEmpty() {

    }


    public TLDocumentEmpty(        long _id) {
        this.id = _id;

    }


    public int getClassId() {
        return CLASS_ID;
    }




    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.id, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readLong(stream);
    }



    @Override
    public String toString() {
        return "documentEmpty#36f8c871";
    }

}
