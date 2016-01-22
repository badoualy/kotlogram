package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestMessagesReceivedQueue extends TLMethod<TLVector<Long>> {
    public static final int CLASS_ID = 0x55a5bb66;

    protected int maxQts;

    public TLRequestMessagesReceivedQueue() {
    }

    public TLRequestMessagesReceivedQueue(int maxQts) {
        this.maxQts = maxQts;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLVector<Long> deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLVector)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLVector<Long>) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(maxQts, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        maxQts = readInt(stream);
    }

    @Override
    public String toString() {
        return "messages.receivedQueue#55a5bb66";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getMaxQts() {
        return maxQts;
    }

    public void setMaxQts(int maxQts) {
        this.maxQts = maxQts;
    }
}
