package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateBotWebhookJSON extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x8317c0c3;

    protected TLDataJSON data;

    private final String _constructor = "updateBotWebhookJSON#8317c0c3";

    public TLUpdateBotWebhookJSON() {
    }

    public TLUpdateBotWebhookJSON(TLDataJSON data) {
        this.data = data;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(data, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        data = readTLObject(stream, context, TLDataJSON.class, TLDataJSON.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += data.computeSerializedSize();
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

    public TLDataJSON getData() {
        return data;
    }

    public void setData(TLDataJSON data) {
        this.data = data;
    }
}
