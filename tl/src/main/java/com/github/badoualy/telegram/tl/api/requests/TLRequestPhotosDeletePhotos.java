
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestPhotosDeletePhotos extends TLMethod<com.github.badoualy.telegram.tl.core.TLLongVector> {

    public static final int CLASS_ID = 0x87cf7f2f;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestPhotosDeletePhotos(        com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputPhoto> _id) {
        this.id = _id;

    }



    public com.github.badoualy.telegram.tl.core.TLLongVector deserializeResponse(InputStream stream, TLContext context) throws IOException {

        return readTLLongVector(stream, context);

    }
        


    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputPhoto> id;


    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputPhoto> getId() {
        return id;
    }

    public void setId(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputPhoto> value) {
        this.id = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.id, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "photos.deletePhotos#87cf7f2f";
    }

}
