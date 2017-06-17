package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsDocument;
import com.github.badoualy.telegram.tl.api.TLStickerPack;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLStickerSet extends TLObject {

    public static final int CONSTRUCTOR_ID = 0xb60a24a6;

    protected com.github.badoualy.telegram.tl.api.TLStickerSet set;

    protected TLVector<TLStickerPack> packs;

    protected TLVector<TLAbsDocument> documents;

    private final String _constructor = "messages.stickerSet#b60a24a6";

    public TLStickerSet() {
    }

    public TLStickerSet(com.github.badoualy.telegram.tl.api.TLStickerSet set, TLVector<TLStickerPack> packs, TLVector<TLAbsDocument> documents) {
        this.set = set;
        this.packs = packs;
        this.documents = documents;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(set, stream);
        writeTLVector(packs, stream);
        writeTLVector(documents, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        set = readTLObject(stream, context, com.github.badoualy.telegram.tl.api.TLStickerSet.class,
                           com.github.badoualy.telegram.tl.api.TLStickerSet.CONSTRUCTOR_ID);
        packs = readTLVector(stream, context);
        documents = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += set.computeSerializedSize();
        size += packs.computeSerializedSize();
        size += documents.computeSerializedSize();
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

    public com.github.badoualy.telegram.tl.api.TLStickerSet getSet() {
        return set;
    }

    public void setSet(com.github.badoualy.telegram.tl.api.TLStickerSet set) {
        this.set = set;
    }

    public TLVector<TLStickerPack> getPacks() {
        return packs;
    }

    public void setPacks(TLVector<TLStickerPack> packs) {
        this.packs = packs;
    }

    public TLVector<TLAbsDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(TLVector<TLAbsDocument> documents) {
        this.documents = documents;
    }
}
