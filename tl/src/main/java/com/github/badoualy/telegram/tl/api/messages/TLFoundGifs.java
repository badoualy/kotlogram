package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsFoundGif;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLFoundGifs extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x450a1c0a;

    protected int nextOffset;

    protected TLVector<TLAbsFoundGif> results;

    private final String _constructor = "messages.foundGifs#450a1c0a";

    public TLFoundGifs() {
    }

    public TLFoundGifs(int nextOffset, TLVector<TLAbsFoundGif> results) {
        this.nextOffset = nextOffset;
        this.results = results;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(nextOffset, stream);
        writeTLVector(results, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        nextOffset = readInt(stream);
        results = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += results.computeSerializedSize();
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

    public int getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(int nextOffset) {
        this.nextOffset = nextOffset;
    }

    public TLVector<TLAbsFoundGif> getResults() {
        return results;
    }

    public void setResults(TLVector<TLAbsFoundGif> results) {
        this.results = results;
    }
}
