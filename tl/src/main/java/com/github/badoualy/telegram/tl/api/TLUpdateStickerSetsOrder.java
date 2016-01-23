package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateStickerSetsOrder extends TLAbsUpdate {
    public static final int CLASS_ID = 0xf0dfb451;

    protected TLVector<Long> order;

    public TLUpdateStickerSetsOrder() {
    }

    public TLUpdateStickerSetsOrder(TLVector<Long> order) {
        this.order = order;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(order, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        order = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "updateStickerSetsOrder#f0dfb451";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLVector<Long> getOrder() {
        return order;
    }

    public void setOrder(TLVector<Long> order) {
        this.order = order;
    }
}
