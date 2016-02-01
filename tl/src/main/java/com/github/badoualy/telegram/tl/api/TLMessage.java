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
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

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

    protected int fromId;

    protected TLAbsPeer toId;

    protected TLAbsPeer fwdFromId;

    protected int fwdDate;

    protected int viaBotId;

    protected int replyToMsgId;

    protected int date;

    protected String message;

    protected TLAbsMessageMedia media;

    protected TLAbsReplyMarkup replyMarkup;

    protected TLVector<TLAbsMessageEntity> entities;

    protected int views;

    public TLMessage() {
    }

    public TLMessage(int flags, boolean unread, boolean out, boolean mentioned, boolean mediaUnread, int id, int fromId, TLAbsPeer toId, TLAbsPeer fwdFromId, int fwdDate, int viaBotId, int replyToMsgId, int date, String message, TLAbsMessageMedia media, TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities, int views) {
        this.flags = flags;
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

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        flags = 0;
        flags = unread ? (flags | 1) : (flags &~ 1);
        flags = out ? (flags | 2) : (flags &~ 2);
        flags = mentioned ? (flags | 16) : (flags &~ 16);
        flags = mediaUnread ? (flags | 32) : (flags &~ 32);

        writeInt(flags, stream);
        if ((flags & 1) != 0) writeTLBool(unread, stream);
        if ((flags & 2) != 0) writeTLBool(out, stream);
        if ((flags & 16) != 0) writeTLBool(mentioned, stream);
        if ((flags & 32) != 0) writeTLBool(mediaUnread, stream);
        writeInt(id, stream);
        if ((flags & 256) != 0) writeInt(fromId, stream);
        writeTLObject(toId, stream);
        if ((flags & 4) != 0) writeTLObject(fwdFromId, stream);
        if ((flags & 4) != 0) writeInt(fwdDate, stream);
        if ((flags & 2048) != 0) writeInt(viaBotId, stream);
        if ((flags & 8) != 0) writeInt(replyToMsgId, stream);
        writeInt(date, stream);
        writeTLString(message, stream);
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
        if ((flags & 256) != 0) fromId = readInt(stream);
        toId = (com.github.badoualy.telegram.tl.api.TLAbsPeer) readTLObject(stream, context);
        if ((flags & 4) != 0) fwdFromId = (com.github.badoualy.telegram.tl.api.TLAbsPeer) readTLObject(stream, context);
        if ((flags & 4) != 0) fwdDate = readInt(stream);
        if ((flags & 2048) != 0) viaBotId = readInt(stream);
        if ((flags & 8) != 0) replyToMsgId = readInt(stream);
        date = readInt(stream);
        message = readTLString(stream);
        if ((flags & 512) != 0) media = (com.github.badoualy.telegram.tl.api.TLAbsMessageMedia) readTLObject(stream, context);
        if ((flags & 64) != 0) replyMarkup = (com.github.badoualy.telegram.tl.api.TLAbsReplyMarkup) readTLObject(stream, context);
        if ((flags & 128) != 0) entities = readTLVector(stream, context);
        if ((flags & 1024) != 0) views = readInt(stream);
    }

    @Override
    public String toString() {
        return "message#c992e15c";
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

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
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

    public int getFwdDate() {
        return fwdDate;
    }

    public void setFwdDate(int fwdDate) {
        this.fwdDate = fwdDate;
    }

    public int getViaBotId() {
        return viaBotId;
    }

    public void setViaBotId(int viaBotId) {
        this.viaBotId = viaBotId;
    }

    public int getReplyToMsgId() {
        return replyToMsgId;
    }

    public void setReplyToMsgId(int replyToMsgId) {
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

    public TLVector<TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(TLVector<TLAbsMessageEntity> entities) {
        this.entities = entities;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
