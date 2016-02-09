package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateShortSentMessage extends TLAbsUpdates {
    public static final int CONSTRUCTOR_ID = 0x11f1331c;

    protected int flags;

    protected boolean unread;

    protected boolean out;

    protected int id;

    protected int pts;

    protected int ptsCount;

    protected int date;

    protected TLAbsMessageMedia media;

    protected TLVector<TLAbsMessageEntity> entities;

    public TLUpdateShortSentMessage() {
    }

    public TLUpdateShortSentMessage(boolean unread, boolean out, int id, int pts, int ptsCount, int date, TLAbsMessageMedia media, TLVector<TLAbsMessageEntity> entities) {
        this.unread = unread;
        this.out = out;
        this.id = id;
        this.pts = pts;
        this.ptsCount = ptsCount;
        this.date = date;
        this.media = media;
        this.entities = entities;
    }

    private void computeFlags() {
        flags = 0;
        flags = unread ? (flags | 1) : (flags &~ 1);
        flags = out ? (flags | 2) : (flags &~ 2);
        flags = media != null ? (flags | 512) : (flags &~ 512);
        flags = entities != null ? (flags | 128) : (flags &~ 128);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(id, stream);
        writeInt(pts, stream);
        writeInt(ptsCount, stream);
        writeInt(date, stream);
        if ((flags & 512) != 0) writeTLObject(media, stream);
        if ((flags & 128) != 0) writeTLVector(entities, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        unread = (flags & 1) != 0;
        out = (flags & 2) != 0;
        id = readInt(stream);
        pts = readInt(stream);
        ptsCount = readInt(stream);
        date = readInt(stream);
        media = (flags & 512) != 0 ? readTLObject(stream, context, TLAbsMessageMedia.class, -1) : null;
        entities = (flags & 128) != 0 ? readTLVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 512) != 0) size += media.computeSerializedSize();
        if ((flags & 128) != 0) size += entities.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "updateShortSentMessage#11f1331c";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLUpdateShortSentMessage)) return false;
        if (object == this) return true;

        TLUpdateShortSentMessage o = (TLUpdateShortSentMessage) object;

        return flags == o.flags
                && unread == o.unread
                && out == o.out
                && id == o.id
                && pts == o.pts
                && ptsCount == o.ptsCount
                && date == o.date
                && (media == o.media || (media != null && o.media != null && media.equals(o.media)))
                && (entities == o.entities || (entities != null && o.entities != null && entities.equals(o.entities)));
    }

    public boolean getUnread() {
        return unread;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }

    public boolean getOut() {
        return out;
    }

    public void setOut(boolean out) {
        this.out = out;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getPtsCount() {
        return ptsCount;
    }

    public void setPtsCount(int ptsCount) {
        this.ptsCount = ptsCount;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TLAbsMessageMedia getMedia() {
        return media;
    }

    public void setMedia(TLAbsMessageMedia media) {
        this.media = media;
    }

    public TLVector<TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(TLVector<TLAbsMessageEntity> entities) {
        this.entities = entities;
    }
}
