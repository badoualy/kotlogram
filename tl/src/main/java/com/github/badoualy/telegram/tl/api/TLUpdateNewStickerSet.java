package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.messages.TLStickerSet;

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
public class TLUpdateNewStickerSet extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x688a30aa;

    protected TLStickerSet stickerset;

    public TLUpdateNewStickerSet() {
    }

    public TLUpdateNewStickerSet(TLStickerSet stickerset) {
        this.stickerset = stickerset;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(stickerset, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        stickerset = readTLObject(stream, context, TLStickerSet.class, TLStickerSet.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += stickerset.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "updateNewStickerSet#688a30aa";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLUpdateNewStickerSet)) return false;
        if (object == this) return true;

        TLUpdateNewStickerSet o = (TLUpdateNewStickerSet) object;

        return (stickerset == o.stickerset || (stickerset != null && o.stickerset != null && stickerset.equals(o.stickerset)));
    }

    public TLStickerSet getStickerset() {
        return stickerset;
    }

    public void setStickerset(TLStickerSet stickerset) {
        this.stickerset = stickerset;
    }
}
