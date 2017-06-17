package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsDocument;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLStickers extends TLAbsStickers {

    public static final int CONSTRUCTOR_ID = 0x8a8ecd32;

    protected String hash;

    protected TLVector<TLAbsDocument> stickers;

    private final String _constructor = "messages.stickers#8a8ecd32";

    public TLStickers() {
    }

    public TLStickers(String hash, TLVector<TLAbsDocument> stickers) {
        this.hash = hash;
        this.stickers = stickers;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(hash, stream);
        writeTLVector(stickers, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        hash = readTLString(stream);
        stickers = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(hash);
        size += stickers.computeSerializedSize();
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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public TLVector<TLAbsDocument> getStickers() {
        return stickers;
    }

    public void setStickers(TLVector<TLAbsDocument> stickers) {
        this.stickers = stickers;
    }
}
