package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUserProfilePhoto extends TLAbsUserProfilePhoto {
    public static final int CLASS_ID = 0xd559d8c8;

    protected long photoId;

    protected TLAbsFileLocation photoSmall;

    protected TLAbsFileLocation photoBig;

    public TLUserProfilePhoto() {
    }

    public TLUserProfilePhoto(long photoId, TLAbsFileLocation photoSmall, TLAbsFileLocation photoBig) {
        this.photoId = photoId;
        this.photoSmall = photoSmall;
        this.photoBig = photoBig;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(photoId, stream);
        writeTLObject(photoSmall, stream);
        writeTLObject(photoBig, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        photoId = readLong(stream);
        photoSmall = (com.github.badoualy.telegram.tl.api.TLAbsFileLocation) readTLObject(stream, context);
        photoBig = (com.github.badoualy.telegram.tl.api.TLAbsFileLocation) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "userProfilePhoto#d559d8c8";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }

    public TLAbsFileLocation getPhotoSmall() {
        return photoSmall;
    }

    public void setPhotoSmall(TLAbsFileLocation photoSmall) {
        this.photoSmall = photoSmall;
    }

    public TLAbsFileLocation getPhotoBig() {
        return photoBig;
    }

    public void setPhotoBig(TLAbsFileLocation photoBig) {
        this.photoBig = photoBig;
    }
}
