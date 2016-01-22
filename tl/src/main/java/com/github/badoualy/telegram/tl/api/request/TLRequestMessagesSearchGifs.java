package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.messages.TLFoundGifs;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesSearchGifs extends TLMethod<TLFoundGifs> {
    public static final int CLASS_ID = 0xbf9a776b;

    protected String q;

    protected int offset;

    public TLRequestMessagesSearchGifs() {
    }

    public TLRequestMessagesSearchGifs(String q, int offset) {
        this.q = q;
        this.offset = offset;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLFoundGifs deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLFoundGifs)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLFoundGifs) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(q, stream);
        writeInt(offset, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        q = readTLString(stream);
        offset = readInt(stream);
    }

    @Override
    public String toString() {
        return "messages.searchGifs#bf9a776b";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
