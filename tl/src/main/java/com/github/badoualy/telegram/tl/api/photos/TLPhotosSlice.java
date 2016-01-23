package com.github.badoualy.telegram.tl.api.photos;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsPhoto;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPhotosSlice extends TLAbsPhotos {
    public static final int CLASS_ID = 0x15051f54;

    protected int count;

    protected TLVector<TLAbsPhoto> photos;

    protected TLVector<TLAbsUser> users;

    public TLPhotosSlice() {
    }

    public TLPhotosSlice(int count, TLVector<TLAbsPhoto> photos, TLVector<TLAbsUser> users) {
        this.count = count;
        this.photos = photos;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(count, stream);
        writeTLVector(photos, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        count = readInt(stream);
        photos = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "photos.photosSlice#15051f54";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public TLVector<TLAbsPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(TLVector<TLAbsPhoto> photos) {
        this.photos = photos;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
