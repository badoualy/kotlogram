package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLPageBlockCollage extends TLAbsPageBlock {

    public static final int CONSTRUCTOR_ID = 0x8b31c4f;

    protected TLVector<TLAbsPageBlock> items;

    protected TLAbsRichText caption;

    private final String _constructor = "pageBlockCollage#8b31c4f";

    public TLPageBlockCollage() {
    }

    public TLPageBlockCollage(TLVector<TLAbsPageBlock> items, TLAbsRichText caption) {
        this.items = items;
        this.caption = caption;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(items, stream);
        writeTLObject(caption, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        items = readTLVector(stream, context);
        caption = readTLObject(stream, context, TLAbsRichText.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += items.computeSerializedSize();
        size += caption.computeSerializedSize();
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

    public TLVector<TLAbsPageBlock> getItems() {
        return items;
    }

    public void setItems(TLVector<TLAbsPageBlock> items) {
        this.items = items;
    }

    public TLAbsRichText getCaption() {
        return caption;
    }

    public void setCaption(TLAbsRichText caption) {
        this.caption = caption;
    }
}
