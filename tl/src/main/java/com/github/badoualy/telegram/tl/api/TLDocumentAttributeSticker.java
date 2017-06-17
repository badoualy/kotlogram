package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLDocumentAttributeSticker extends TLAbsDocumentAttribute {

    public static final int CONSTRUCTOR_ID = 0x6319d612;

    protected int flags;

    protected boolean mask;

    protected String alt;

    protected TLAbsInputStickerSet stickerset;

    protected TLMaskCoords maskCoords;

    private final String _constructor = "documentAttributeSticker#6319d612";

    public TLDocumentAttributeSticker() {
    }

    public TLDocumentAttributeSticker(boolean mask, String alt, TLAbsInputStickerSet stickerset, TLMaskCoords maskCoords) {
        this.mask = mask;
        this.alt = alt;
        this.stickerset = stickerset;
        this.maskCoords = maskCoords;
    }

    private void computeFlags() {
        flags = 0;
        flags = mask ? (flags | 2) : (flags & ~2);
        flags = maskCoords != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(alt, stream);
        writeTLObject(stickerset, stream);
        if ((flags & 1) != 0) {
            if (maskCoords == null) throwNullFieldException("maskCoords", flags);
            writeTLObject(maskCoords, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        mask = (flags & 2) != 0;
        alt = readTLString(stream);
        stickerset = readTLObject(stream, context, TLAbsInputStickerSet.class, -1);
        maskCoords = (flags & 1) != 0 ? readTLObject(stream, context, TLMaskCoords.class,
                                                     TLMaskCoords.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(alt);
        size += stickerset.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (maskCoords == null) throwNullFieldException("maskCoords", flags);
            size += maskCoords.computeSerializedSize();
        }
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

    public boolean getMask() {
        return mask;
    }

    public void setMask(boolean mask) {
        this.mask = mask;
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

    public TLMaskCoords getMaskCoords() {
        return maskCoords;
    }

    public void setMaskCoords(TLMaskCoords maskCoords) {
        this.maskCoords = maskCoords;
    }
}
