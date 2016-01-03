
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputMediaUploadedPhoto extends TLAbsInputMedia {
    public static final int CLASS_ID = 0x2dc53a7d;

    public TLInputMediaUploadedPhoto() {

    }


    public TLInputMediaUploadedPhoto(        com.github.badoualy.telegram.tl.api.TLAbsInputFile _file) {
        this.file = _file;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsInputFile file;


    public com.github.badoualy.telegram.tl.api.TLAbsInputFile getFile() {
        return file;
    }

    public void setFile(com.github.badoualy.telegram.tl.api.TLAbsInputFile value) {
        this.file = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.file, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.file = (com.github.badoualy.telegram.tl.api.TLAbsInputFile)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "inputMediaUploadedPhoto#2dc53a7d";
    }

}
