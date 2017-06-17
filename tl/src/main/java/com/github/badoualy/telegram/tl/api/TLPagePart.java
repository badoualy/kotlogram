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
public class TLPagePart extends TLAbsPage {

    public static final int CONSTRUCTOR_ID = 0x8dee6c44;

    private final String _constructor = "pagePart#8dee6c44";

    public TLPagePart() {
    }

    public TLPagePart(TLVector<TLAbsPageBlock> blocks, TLVector<TLAbsPhoto> photos, TLVector<TLAbsDocument> videos) {
        this.blocks = blocks;
        this.photos = photos;
        this.videos = videos;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(blocks, stream);
        writeTLVector(photos, stream);
        writeTLVector(videos, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        blocks = readTLVector(stream, context);
        photos = readTLVector(stream, context);
        videos = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += blocks.computeSerializedSize();
        size += photos.computeSerializedSize();
        size += videos.computeSerializedSize();
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

    public TLVector<TLAbsPageBlock> getBlocks() {
        return blocks;
    }

    public void setBlocks(TLVector<TLAbsPageBlock> blocks) {
        this.blocks = blocks;
    }

    public TLVector<TLAbsPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(TLVector<TLAbsPhoto> photos) {
        this.photos = photos;
    }

    public TLVector<TLAbsDocument> getVideos() {
        return videos;
    }

    public void setVideos(TLVector<TLAbsDocument> videos) {
        this.videos = videos;
    }
}
