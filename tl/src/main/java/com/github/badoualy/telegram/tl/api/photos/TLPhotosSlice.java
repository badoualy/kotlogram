
package com.github.badoualy.telegram.tl.api.photos;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLPhotosSlice extends TLAbsPhotos {
    public static final int CLASS_ID = 0x15051f54;

    public TLPhotosSlice() {

    }


    public TLPhotosSlice(        int _count,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsPhoto> _photos,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> _users) {
        this.count = _count;
        this.photos = _photos;
        this.users = _users;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int count;


    public int getCount() {
        return count;
    }

    public void setCount(int value) {
        this.count = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.count, stream);
        writeTLVector(this.photos, stream);
        writeTLVector(this.users, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.count = readInt(stream);
        this.photos = readTLVector(stream, context);
        this.users = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "photos.photosSlice#15051f54";
    }

}
