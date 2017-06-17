package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMediaUploadedDocument extends TLAbsInputMedia {

    public static final int CONSTRUCTOR_ID = 0xd070f1e9;

    protected int flags;

    protected TLAbsInputFile file;

    protected String mimeType;

    protected TLVector<TLAbsDocumentAttribute> attributes;

    protected String caption;

    protected TLVector<TLAbsInputDocument> stickers;

    private final String _constructor = "inputMediaUploadedDocument#d070f1e9";

    public TLInputMediaUploadedDocument() {
    }

    public TLInputMediaUploadedDocument(TLAbsInputFile file, String mimeType, TLVector<TLAbsDocumentAttribute> attributes, String caption, TLVector<TLAbsInputDocument> stickers) {
        this.file = file;
        this.mimeType = mimeType;
        this.attributes = attributes;
        this.caption = caption;
        this.stickers = stickers;
    }

    private void computeFlags() {
        flags = 0;
        flags = stickers != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(file, stream);
        writeString(mimeType, stream);
        writeTLVector(attributes, stream);
        writeString(caption, stream);
        if ((flags & 1) != 0) {
            if (stickers == null) throwNullFieldException("stickers", flags);
            writeTLVector(stickers, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        file = readTLObject(stream, context, TLAbsInputFile.class, -1);
        mimeType = readTLString(stream);
        attributes = readTLVector(stream, context);
        caption = readTLString(stream);
        stickers = (flags & 1) != 0 ? readTLVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += file.computeSerializedSize();
        size += computeTLStringSerializedSize(mimeType);
        size += attributes.computeSerializedSize();
        size += computeTLStringSerializedSize(caption);
        if ((flags & 1) != 0) {
            if (stickers == null) throwNullFieldException("stickers", flags);
            size += stickers.computeSerializedSize();
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

    public TLAbsInputFile getFile() {
        return file;
    }

    public void setFile(TLAbsInputFile file) {
        this.file = file;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public TLVector<TLAbsDocumentAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(TLVector<TLAbsDocumentAttribute> attributes) {
        this.attributes = attributes;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public TLVector<TLAbsInputDocument> getStickers() {
        return stickers;
    }

    public void setStickers(TLVector<TLAbsInputDocument> stickers) {
        this.stickers = stickers;
    }
}
