package com.github.badoualy.telegram.tl.core;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLLongVector extends TLVector<Long> {

    public TLLongVector() {
        super(Long.class);
    }

    @Override
    protected void serializeItem(Long item, OutputStream stream) throws IOException {
        writeLong(item, stream);
    }

    @Override
    protected Long deserializeItem(InputStream stream, TLContext context) throws IOException {
        return readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        return SIZE_CONSTRUCTOR_ID + SIZE_INT32 + SIZE_INT64 * size();
    }

    @Override
    public String toString() {
        return "vector<long>#1cb5c415";
    }

    public long[] toLongArray() {
        long[] array = new long[size()];
        for (int i = 0; i < array.length; i++)
            array[i] = items.get(i);
        return array;
    }
}
