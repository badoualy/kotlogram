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
public class TLMessageActionChatEditPhoto extends TLAbsMessageAction {
    public static final int CONSTRUCTOR_ID = 0x7fcb13a8;

    protected TLAbsPhoto photo;

    public TLMessageActionChatEditPhoto() {
    }

    public TLMessageActionChatEditPhoto(TLAbsPhoto photo) {
        this.photo = photo;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(photo, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        photo = readTLObject(stream, context, TLAbsPhoto.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += photo.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "messageActionChatEditPhoto#7fcb13a8";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLMessageActionChatEditPhoto)) return false;
        if (object == this) return true;

        TLMessageActionChatEditPhoto o = (TLMessageActionChatEditPhoto) object;

        return (photo == o.photo || (photo != null && o.photo != null && photo.equals(o.photo)));
    }

    public TLAbsPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsPhoto photo) {
        this.photo = photo;
    }
}
