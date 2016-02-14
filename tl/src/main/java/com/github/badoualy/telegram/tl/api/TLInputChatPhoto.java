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
public class TLInputChatPhoto extends TLAbsInputChatPhoto {
    public static final int CONSTRUCTOR_ID = 0xb2e1bf08;

    protected TLAbsInputPhoto id;

    protected TLAbsInputPhotoCrop crop;

    private final String _constructor = "inputChatPhoto#b2e1bf08";

    public TLInputChatPhoto() {
    }

    public TLInputChatPhoto(TLAbsInputPhoto id, TLAbsInputPhotoCrop crop) {
        this.id = id;
        this.crop = crop;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(id, stream);
        writeTLObject(crop, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readTLObject(stream, context, TLAbsInputPhoto.class, -1);
        crop = readTLObject(stream, context, TLAbsInputPhotoCrop.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += id.computeSerializedSize();
        size += crop.computeSerializedSize();
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
        if (!(object instanceof TLInputChatPhoto)) return false;
        if (object == this) return true;

        TLInputChatPhoto o = (TLInputChatPhoto) object;

        return (id == o.id || (id != null && o.id != null && id.equals(o.id)))
                && (crop == o.crop || (crop != null && o.crop != null && crop.equals(o.crop)));
    }

    public TLAbsInputPhoto getId() {
        return id;
    }

    public void setId(TLAbsInputPhoto id) {
        this.id = id;
    }

    public TLAbsInputPhotoCrop getCrop() {
        return crop;
    }

    public void setCrop(TLAbsInputPhotoCrop crop) {
        this.crop = crop;
    }
}
