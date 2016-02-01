package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeBoolean;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

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

    public TLUpdateShortSentMessage(int flags, boolean unread, boolean out, int id, int pts, int ptsCount, int date, TLAbsMessageMedia media, TLVector<TLAbsMessageEntity> entities) {
        this.flags = flags;
        this.unread = unread;
        this.out = out;
        this.id = id;
        this.pts = pts;
        this.ptsCount = ptsCount;
        this.date = date;
        this.media = media;
        this.entities = entities;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        flags = 0;
        flags = unread ? (flags | 1) : (flags &~ 1);
        flags = out ? (flags | 2) : (flags &~ 2);

        writeInt(flags, stream);
        if ((flags & 1) != 0) writeBoolean(unread, stream);
        if ((flags & 2) != 0) writeBoolean(out, stream);
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
        if ((flags & 512) != 0) media = (com.github.badoualy.telegram.tl.api.TLAbsMessageMedia) readTLObject(stream, context);
        if ((flags & 128) != 0) entities = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "updateShortSentMessage#11f1331c";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
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
