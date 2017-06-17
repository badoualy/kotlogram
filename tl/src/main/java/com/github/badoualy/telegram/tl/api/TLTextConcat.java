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
public class TLTextConcat extends TLAbsRichText {

    public static final int CONSTRUCTOR_ID = 0x7e6260d7;

    protected TLVector<TLAbsRichText> texts;

    private final String _constructor = "textConcat#7e6260d7";

    public TLTextConcat() {
    }

    public TLTextConcat(TLVector<TLAbsRichText> texts) {
        this.texts = texts;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(texts, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        texts = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += texts.computeSerializedSize();
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

    public TLVector<TLAbsRichText> getTexts() {
        return texts;
    }

    public void setTexts(TLVector<TLAbsRichText> texts) {
        this.texts = texts;
    }
}
