package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChatPhoto extends TLAbsChatPhoto {
    public static final int CONSTRUCTOR_ID = 0x6153276a;

    protected TLAbsFileLocation photoSmall;

    protected TLAbsFileLocation photoBig;

    private final String _constructor = "chatPhoto#6153276a";

    public TLChatPhoto() {
    }

    public TLChatPhoto(TLAbsFileLocation photoSmall, TLAbsFileLocation photoBig) {
        this.photoSmall = photoSmall;
        this.photoBig = photoBig;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(photoSmall, stream);
        writeTLObject(photoBig, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        photoSmall = readTLObject(stream, context, TLAbsFileLocation.class, -1);
        photoBig = readTLObject(stream, context, TLAbsFileLocation.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += photoSmall.computeSerializedSize();
        size += photoBig.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLChatPhoto)) return false;
        if (object == this) return true;

        TLChatPhoto o = (TLChatPhoto) object;

        return (photoSmall == o.photoSmall || (photoSmall != null && o.photoSmall != null && photoSmall.equals(o.photoSmall)))
                && (photoBig == o.photoBig || (photoBig != null && o.photoBig != null && photoBig.equals(o.photoBig)));
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

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLChatPhoto getAsChatPhoto() {
        return this;
    }
}
