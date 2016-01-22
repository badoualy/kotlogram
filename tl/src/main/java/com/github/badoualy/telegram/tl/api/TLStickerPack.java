package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLStickerPack extends TLObject {
    public static final int CLASS_ID = 0x12b299d4;

    protected String emoticon;

    protected TLVector<Long> documents;

    public TLStickerPack() {
    }

    public TLStickerPack(String emoticon, TLVector<Long> documents) {
        this.emoticon = emoticon;
        this.documents = documents;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(emoticon, stream);
        writeTLVector(documents, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        emoticon = readTLString(stream);
        documents = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "stickerPack#12b299d4";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getEmoticon() {
        return emoticon;
    }

    public void setEmoticon(String emoticon) {
        this.emoticon = emoticon;
    }

    public TLVector<Long> getDocuments() {
        return documents;
    }

    public void setDocuments(TLVector<Long> documents) {
        this.documents = documents;
    }
}
