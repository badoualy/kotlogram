
package com.github.badoualy.telegram.tl.api.photos;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLPhotos extends TLAbsPhotos {
    public static final int CLASS_ID = 0x8dca6aa5;

    public TLPhotos() {

    }


    public TLPhotos(        com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsPhoto> _photos,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> _users) {
        this.photos = _photos;
        this.users = _users;

    }


    public int getClassId() {
        return CLASS_ID;
    }




    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.photos, stream);
        writeTLVector(this.users, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.photos = readTLVector(stream, context);
        this.users = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "photos.photos#8dca6aa5";
    }

}
