
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLPhotoSizeEmpty extends TLAbsPhotoSize {
    public static final int CLASS_ID = 0xe17e23c;

    public TLPhotoSizeEmpty() {

    }


    public TLPhotoSizeEmpty(        String _type) {
        this.type = _type;

    }


    public int getClassId() {
        return CLASS_ID;
    }




    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.type, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.type = readTLString(stream);
    }



    @Override
    public String toString() {
        return "photoSizeEmpty#e17e23c";
    }

}
