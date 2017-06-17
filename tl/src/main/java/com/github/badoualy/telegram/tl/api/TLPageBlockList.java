package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeBoolean;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPageBlockList extends TLAbsPageBlock {

    public static final int CONSTRUCTOR_ID = 0x3a58c7f4;

    protected boolean ordered;

    protected TLVector<TLAbsRichText> items;

    private final String _constructor = "pageBlockList#3a58c7f4";

    public TLPageBlockList() {
    }

    public TLPageBlockList(boolean ordered, TLVector<TLAbsRichText> items) {
        this.ordered = ordered;
        this.items = items;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeBoolean(ordered, stream);
        writeTLVector(items, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        ordered = readTLBool(stream);
        items = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_BOOLEAN;
        size += items.computeSerializedSize();
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

    public boolean getOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    public TLVector<TLAbsRichText> getItems() {
        return items;
    }

    public void setItems(TLVector<TLAbsRichText> items) {
        this.items = items;
    }
}
