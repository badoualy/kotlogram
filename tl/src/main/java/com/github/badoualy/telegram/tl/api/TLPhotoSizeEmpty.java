
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



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
