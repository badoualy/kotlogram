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
public class TLMessageMediaWebPage extends TLAbsMessageMedia {

    public static final int CONSTRUCTOR_ID = 0xa32dd600;

    protected TLAbsWebPage webpage;

    private final String _constructor = "messageMediaWebPage#a32dd600";

    public TLMessageMediaWebPage() {
    }

    public TLMessageMediaWebPage(TLAbsWebPage webpage) {
        this.webpage = webpage;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(webpage, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        webpage = readTLObject(stream, context, TLAbsWebPage.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += webpage.computeSerializedSize();
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

    public TLAbsWebPage getWebpage() {
        return webpage;
    }

    public void setWebpage(TLAbsWebPage webpage) {
        this.webpage = webpage;
    }
}
