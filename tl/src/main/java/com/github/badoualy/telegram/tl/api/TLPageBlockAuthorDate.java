package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPageBlockAuthorDate extends TLAbsPageBlock {

    public static final int CONSTRUCTOR_ID = 0xbaafe5e0;

    protected TLAbsRichText author;

    protected int publishedDate;

    private final String _constructor = "pageBlockAuthorDate#baafe5e0";

    public TLPageBlockAuthorDate() {
    }

    public TLPageBlockAuthorDate(TLAbsRichText author, int publishedDate) {
        this.author = author;
        this.publishedDate = publishedDate;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(author, stream);
        writeInt(publishedDate, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        author = readTLObject(stream, context, TLAbsRichText.class, -1);
        publishedDate = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += author.computeSerializedSize();
        size += SIZE_INT32;
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

    public TLAbsRichText getAuthor() {
        return author;
    }

    public void setAuthor(TLAbsRichText author) {
        this.author = author;
    }

    public int getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(int publishedDate) {
        this.publishedDate = publishedDate;
    }
}
