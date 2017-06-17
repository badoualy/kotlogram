package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPageBlockVideo extends TLAbsPageBlock {

    public static final int CONSTRUCTOR_ID = 0xd9d71866;

    protected int flags;

    protected boolean autoplay;

    protected boolean loop;

    protected long videoId;

    protected TLAbsRichText caption;

    private final String _constructor = "pageBlockVideo#d9d71866";

    public TLPageBlockVideo() {
    }

    public TLPageBlockVideo(boolean autoplay, boolean loop, long videoId, TLAbsRichText caption) {
        this.autoplay = autoplay;
        this.loop = loop;
        this.videoId = videoId;
        this.caption = caption;
    }

    private void computeFlags() {
        flags = 0;
        flags = autoplay ? (flags | 1) : (flags & ~1);
        flags = loop ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(videoId, stream);
        writeTLObject(caption, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        autoplay = (flags & 1) != 0;
        loop = (flags & 2) != 0;
        videoId = readLong(stream);
        caption = readTLObject(stream, context, TLAbsRichText.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
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

    public boolean getAutoplay() {
        return autoplay;
    }

    public void setAutoplay(boolean autoplay) {
        this.autoplay = autoplay;
    }

    public boolean getLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public long getVideoId() {
        return videoId;
    }

    public void setVideoId(long videoId) {
        this.videoId = videoId;
    }

    public TLAbsRichText getCaption() {
        return caption;
    }

    public void setCaption(TLAbsRichText caption) {
        this.caption = caption;
    }
}
