package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPhoto;
import com.github.badoualy.telegram.tl.core.TLLongVector;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestPhotosDeletePhotos extends TLMethod<TLLongVector> {
    public static final int CONSTRUCTOR_ID = 0x87cf7f2f;

    protected TLVector<? extends TLAbsInputPhoto> id;

    public TLRequestPhotosDeletePhotos() {
    }

    public TLRequestPhotosDeletePhotos(TLVector<? extends TLAbsInputPhoto> id) {
        this.id = id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLLongVector deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLLongVector)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLLongVector) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(id, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += id.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "photos.deletePhotos#87cf7f2f";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLRequestPhotosDeletePhotos)) return false;
        if (object == this) return true;

        TLRequestPhotosDeletePhotos o = (TLRequestPhotosDeletePhotos) object;

        return (id == o.id || (id != null && o.id != null && id.equals(o.id)));
    }

    public TLVector<? extends TLAbsInputPhoto> getId() {
        return id;
    }

    public void setId(TLVector<? extends TLAbsInputPhoto> id) {
        this.id = id;
    }
}
