package com.github.badoualy.telegram.tl.core;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.TLObjectUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLStringVector extends TLVector<String> {

    public TLStringVector() {
        super(String.class);
    }

    @Override
    protected void serializeItem(String item, OutputStream stream) throws IOException {
        writeString(item, stream);
    }

    @Override
    protected String deserializeItem(InputStream stream, TLContext context) throws IOException {
        return readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID + SIZE_INT32;
        for (String item : items)
            size += TLObjectUtils.computeTLStringSerializedSize(item);
        return size;
    }


    @Override
    public String toString() {
        return "vector<string>#1cb5c415";
    }
}
