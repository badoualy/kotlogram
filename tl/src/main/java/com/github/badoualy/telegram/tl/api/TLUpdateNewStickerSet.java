package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.messages.TLStickerSet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;

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
        stickerset = (com.github.badoualy.telegram.tl.api.messages.TLStickerSet) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "updateNewStickerSet#688a30aa";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLStickerSet getStickerset() {
        return stickerset;
    }

    public void setStickerset(TLStickerSet stickerset) {
        this.stickerset = stickerset;
    }
}
