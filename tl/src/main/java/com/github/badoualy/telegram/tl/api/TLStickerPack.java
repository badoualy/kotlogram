package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLLongVector;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLLongVector;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLStickerPack extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x12b299d4;

    protected String emoticon;

    protected TLLongVector documents;

    public TLStickerPack() {
    }

    public TLStickerPack(String emoticon, TLLongVector documents) {
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
        documents = readTLLongVector(stream, context);
    }

    @Override
    public String toString() {
        return "stickerPack#12b299d4";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public String getEmoticon() {
        return emoticon;
    }

    public void setEmoticon(String emoticon) {
        this.emoticon = emoticon;
    }

    public TLLongVector getDocuments() {
        return documents;
    }

    public void setDocuments(TLLongVector documents) {
        this.documents = documents;
    }
}
