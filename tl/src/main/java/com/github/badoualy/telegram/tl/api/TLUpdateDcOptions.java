package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateDcOptions extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x8e5e9873;

    protected TLVector<TLDcOption> dcOptions;

    private final String _constructor = "updateDcOptions#8e5e9873";

    public TLUpdateDcOptions() {
    }

    public TLUpdateDcOptions(TLVector<TLDcOption> dcOptions) {
        this.dcOptions = dcOptions;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(dcOptions, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        dcOptions = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += dcOptions.computeSerializedSize();
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

    public TLVector<TLDcOption> getDcOptions() {
        return dcOptions;
    }

    public void setDcOptions(TLVector<TLDcOption> dcOptions) {
        this.dcOptions = dcOptions;
    }
}
