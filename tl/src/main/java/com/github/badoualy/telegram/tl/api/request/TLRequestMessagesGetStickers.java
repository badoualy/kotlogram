package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickers;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesGetStickers extends TLMethod<TLAbsStickers> {
    public static final int CONSTRUCTOR_ID = 0xae22e045;

    protected String emoticon;

    protected String hash;

    private final String _constructor = "messages.getStickers#ae22e045";

    public TLRequestMessagesGetStickers() {
    }

    public TLRequestMessagesGetStickers(String emoticon, String hash) {
        this.emoticon = emoticon;
        this.hash = hash;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsStickers deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsStickers)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsStickers) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(emoticon, stream);
        writeString(hash, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        emoticon = readTLString(stream);
        hash = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(emoticon);
        size += computeTLStringSerializedSize(hash);
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

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLRequestMessagesGetStickers)) return false;
        if (object == this) return true;

        TLRequestMessagesGetStickers o = (TLRequestMessagesGetStickers) object;

        return (emoticon == o.emoticon || (emoticon != null && o.emoticon != null && emoticon.equals(o.emoticon)))
                && (hash == o.hash || (hash != null && o.hash != null && hash.equals(o.hash)));
    }

    public String getEmoticon() {
        return emoticon;
    }

    public void setEmoticon(String emoticon) {
        this.emoticon = emoticon;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
