package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPageBlockEmbedPost extends TLAbsPageBlock {

    public static final int CONSTRUCTOR_ID = 0x292c7be9;

    protected String url;

    protected long webpageId;

    protected long authorPhotoId;

    protected String author;

    protected int date;

    protected TLVector<TLAbsPageBlock> blocks;

    protected TLAbsRichText caption;

    private final String _constructor = "pageBlockEmbedPost#292c7be9";

    public TLPageBlockEmbedPost() {
    }

    public TLPageBlockEmbedPost(String url, long webpageId, long authorPhotoId, String author, int date, TLVector<TLAbsPageBlock> blocks, TLAbsRichText caption) {
        this.url = url;
        this.webpageId = webpageId;
        this.authorPhotoId = authorPhotoId;
        this.author = author;
        this.date = date;
        this.blocks = blocks;
        this.caption = caption;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(url, stream);
        writeLong(webpageId, stream);
        writeLong(authorPhotoId, stream);
        writeString(author, stream);
        writeInt(date, stream);
        writeTLVector(blocks, stream);
        writeTLObject(caption, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        url = readTLString(stream);
        webpageId = readLong(stream);
        authorPhotoId = readLong(stream);
        author = readTLString(stream);
        date = readInt(stream);
        blocks = readTLVector(stream, context);
        caption = readTLObject(stream, context, TLAbsRichText.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(url);
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(author);
        size += SIZE_INT32;
        size += blocks.computeSerializedSize();
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getWebpageId() {
        return webpageId;
    }

    public void setWebpageId(long webpageId) {
        this.webpageId = webpageId;
    }

    public long getAuthorPhotoId() {
        return authorPhotoId;
    }

    public void setAuthorPhotoId(long authorPhotoId) {
        this.authorPhotoId = authorPhotoId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TLVector<TLAbsPageBlock> getBlocks() {
        return blocks;
    }

    public void setBlocks(TLVector<TLAbsPageBlock> blocks) {
        this.blocks = blocks;
    }

    public TLAbsRichText getCaption() {
        return caption;
    }

    public void setCaption(TLAbsRichText caption) {
        this.caption = caption;
    }
}
