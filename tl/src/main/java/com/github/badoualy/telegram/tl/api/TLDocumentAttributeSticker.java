package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLDocumentAttributeSticker extends TLAbsDocumentAttribute {
    public static final int CONSTRUCTOR_ID = 0x3a556302;

    protected String alt;

    protected TLAbsInputStickerSet stickerset;

    public TLDocumentAttributeSticker() {
    }

    public TLDocumentAttributeSticker(String alt, TLAbsInputStickerSet stickerset) {
        this.alt = alt;
        this.stickerset = stickerset;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(alt, stream);
        writeTLObject(stickerset, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        alt = readTLString(stream);
        stickerset = (com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "documentAttributeSticker#3a556302";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public TLAbsInputStickerSet getStickerset() {
        return stickerset;
    }

    public void setStickerset(TLAbsInputStickerSet stickerset) {
        this.stickerset = stickerset;
    }
}
