package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessage extends TLAbsMessage {
    public static final int CONSTRUCTOR_ID = 0xc992e15c;

    protected int flags;

    protected boolean unread;

    protected boolean out;

    protected boolean mentioned;

    protected boolean mediaUnread;

    protected Integer fromId;

    protected TLAbsPeer toId;

    protected TLAbsPeer fwdFromId;

    protected Integer fwdDate;

    protected Integer viaBotId;

    protected Integer replyToMsgId;

    protected int date;

    protected String message;

    protected TLAbsMessageMedia media;

    protected TLAbsReplyMarkup replyMarkup;

    protected TLVector<? extends TLAbsMessageEntity> entities;

    protected Integer views;

    public TLMessage() {
    }

    public TLMessage(boolean unread, boolean out, boolean mentioned, boolean mediaUnread, int id, Integer fromId, TLAbsPeer toId, TLAbsPeer fwdFromId, Integer fwdDate, Integer viaBotId, Integer replyToMsgId, int date, String message, TLAbsMessageMedia media, TLAbsReplyMarkup replyMarkup, TLVector<? extends TLAbsMessageEntity> entities, Integer views) {
        this.unread = unread;
        this.out = out;
        this.mentioned = mentioned;
        this.mediaUnread = mediaUnread;
        this.id = id;
        this.fromId = fromId;
        this.toId = toId;
        this.fwdFromId = fwdFromId;
        this.fwdDate = fwdDate;
        this.viaBotId = viaBotId;
        this.replyToMsgId = replyToMsgId;
        this.date = date;
        this.message = message;
        this.media = media;
        this.replyMarkup = replyMarkup;
        this.entities = entities;
        this.views = views;
    }

    private void computeFlags() {
        flags = 0;
        flags = unread ? (flags | 1) : (flags &~ 1);
        flags = out ? (flags | 2) : (flags &~ 2);
        flags = mentioned ? (flags | 16) : (flags &~ 16);
        flags = mediaUnread ? (flags | 32) : (flags &~ 32);
        flags = fromId != null ? (flags | 256) : (flags &~ 256);
        flags = fwdFromId != null ? (flags | 4) : (flags &~ 4);
        flags = fwdDate != null ? (flags | 4) : (flags &~ 4);
        flags = viaBotId != null ? (flags | 2048) : (flags &~ 2048);
        flags = replyToMsgId != null ? (flags | 8) : (flags &~ 8);
        flags = media != null ? (flags | 512) : (flags &~ 512);
        flags = replyMarkup != null ? (flags | 64) : (flags &~ 64);
        flags = entities != null ? (flags | 128) : (flags &~ 128);
        flags = views != null ? (flags | 1024) : (flags &~ 1024);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(id, stream);
        if ((flags & 256) != 0) writeInt(fromId, stream);
        writeTLObject(toId, stream);
        if ((flags & 4) != 0) writeTLObject(fwdFromId, stream);
        if ((flags & 4) != 0) writeInt(fwdDate, stream);
        if ((flags & 2048) != 0) writeInt(viaBotId, stream);
        if ((flags & 8) != 0) writeInt(replyToMsgId, stream);
        writeInt(date, stream);
        writeString(message, stream);
        if ((flags & 512) != 0) writeTLObject(media, stream);
        if ((flags & 64) != 0) writeTLObject(replyMarkup, stream);
        if ((flags & 128) != 0) writeTLVector(entities, stream);
        if ((flags & 1024) != 0) writeInt(views, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        unread = (flags & 1) != 0;
        out = (flags & 2) != 0;
        mentioned = (flags & 16) != 0;
        mediaUnread = (flags & 32) != 0;
        id = readInt(stream);
        fromId = (flags & 256) != 0 ? readInt(stream) : null;
        toId = readTLObject(stream, context, TLAbsPeer.class, -1);
        fwdFromId = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsPeer.class, -1) : null;
        fwdDate = (flags & 4) != 0 ? readInt(stream) : null;
        viaBotId = (flags & 2048) != 0 ? readInt(stream) : null;
        replyToMsgId = (flags & 8) != 0 ? readInt(stream) : null;
        date = readInt(stream);
        message = readTLString(stream);
        media = (flags & 512) != 0 ? readTLObject(stream, context, TLAbsMessageMedia.class, -1) : null;
        replyMarkup = (flags & 64) != 0 ? readTLObject(stream, context, TLAbsReplyMarkup.class, -1) : null;
        entities = (flags & 128) != 0 ? readTLVector(stream, context) : null;
        views = (flags & 1024) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 256) != 0) size += SIZE_INT32;
        size += toId.computeSerializedSize();
        if ((flags & 4) != 0) size += fwdFromId.computeSerializedSize();
        if ((flags & 4) != 0) size += SIZE_INT32;
        if ((flags & 2048) != 0) size += SIZE_INT32;
        if ((flags & 8) != 0) size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(message);
        if ((flags & 512) != 0) size += media.computeSerializedSize();
        if ((flags & 64) != 0) size += replyMarkup.computeSerializedSize();
        if ((flags & 128) != 0) size += entities.computeSerializedSize();
        if ((flags & 1024) != 0) size += SIZE_INT32;
        return size;
    }

    @Override
    public String toString() {
        return "message#c992e15c";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLMessage)) return false;
        if (object == this) return true;

        TLMessage o = (TLMessage) object;

        return flags == o.flags
                && unread == o.unread
                && out == o.out
                && mentioned == o.mentioned
                && mediaUnread == o.mediaUnread
                && id == o.id
                && (fromId == o.fromId || (fromId != null && o.fromId != null && fromId.equals(o.fromId)))
                && (toId == o.toId || (toId != null && o.toId != null && toId.equals(o.toId)))
                && (fwdFromId == o.fwdFromId || (fwdFromId != null && o.fwdFromId != null && fwdFromId.equals(o.fwdFromId)))
                && (fwdDate == o.fwdDate || (fwdDate != null && o.fwdDate != null && fwdDate.equals(o.fwdDate)))
                && (viaBotId == o.viaBotId || (viaBotId != null && o.viaBotId != null && viaBotId.equals(o.viaBotId)))
                && (replyToMsgId == o.replyToMsgId || (replyToMsgId != null && o.replyToMsgId != null && replyToMsgId.equals(o.replyToMsgId)))
                && date == o.date
                && (message == o.message || (message != null && o.message != null && message.equals(o.message)))
                && (media == o.media || (media != null && o.media != null && media.equals(o.media)))
                && (replyMarkup == o.replyMarkup || (replyMarkup != null && o.replyMarkup != null && replyMarkup.equals(o.replyMarkup)))
                && (entities == o.entities || (entities != null && o.entities != null && entities.equals(o.entities)))
                && (views == o.views || (views != null && o.views != null && views.equals(o.views)));
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

    public boolean getMentioned() {
        return mentioned;
    }

    public void setMentioned(boolean mentioned) {
        this.mentioned = mentioned;
    }

    public boolean getMediaUnread() {
        return mediaUnread;
    }

    public void setMediaUnread(boolean mediaUnread) {
        this.mediaUnread = mediaUnread;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public TLAbsPeer getToId() {
        return toId;
    }

    public void setToId(TLAbsPeer toId) {
        this.toId = toId;
    }

    public TLAbsPeer getFwdFromId() {
        return fwdFromId;
    }

    public void setFwdFromId(TLAbsPeer fwdFromId) {
        this.fwdFromId = fwdFromId;
    }

    public Integer getFwdDate() {
        return fwdDate;
    }

    public void setFwdDate(Integer fwdDate) {
        this.fwdDate = fwdDate;
    }

    public Integer getViaBotId() {
        return viaBotId;
    }

    public void setViaBotId(Integer viaBotId) {
        this.viaBotId = viaBotId;
    }

    public Integer getReplyToMsgId() {
        return replyToMsgId;
    }

    public void setReplyToMsgId(Integer replyToMsgId) {
        this.replyToMsgId = replyToMsgId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TLAbsMessageMedia getMedia() {
        return media;
    }

    public void setMedia(TLAbsMessageMedia media) {
        this.media = media;
    }

    public TLAbsReplyMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(TLAbsReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }

    public TLVector<? extends TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(TLVector<? extends TLAbsMessageEntity> entities) {
        this.entities = entities;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }
}
