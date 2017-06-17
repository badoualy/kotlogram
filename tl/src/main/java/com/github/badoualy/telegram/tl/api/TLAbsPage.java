package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLPageFull}: pageFull#d7a19d69</li>
 * <li>{@link TLPagePart}: pagePart#8dee6c44</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsPage extends TLObject {

    protected TLVector<TLAbsPageBlock> blocks;

    protected TLVector<TLAbsPhoto> photos;

    protected TLVector<TLAbsDocument> videos;

    public TLAbsPage() {
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
