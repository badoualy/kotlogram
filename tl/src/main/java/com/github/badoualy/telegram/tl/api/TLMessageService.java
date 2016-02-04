package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeBoolean;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageService extends TLAbsMessage {
    public static final int CONSTRUCTOR_ID = 0xc06b9607;

    protected int flags;

    protected boolean unread;

    protected boolean out;

    protected boolean mentioned;

    protected boolean mediaUnread;

    protected Integer fromId;

    protected TLAbsPeer toId;

    protected int date;

    protected TLAbsMessageAction action;

    public TLMessageService() {
    }

    public TLMessageService(boolean unread, boolean out, boolean mentioned, boolean mediaUnread, int id, Integer fromId, TLAbsPeer toId, int date, TLAbsMessageAction action) {
        this.unread = unread;
        this.out = out;
        this.mentioned = mentioned;
        this.mediaUnread = mediaUnread;
        this.id = id;
        this.fromId = fromId;
        this.toId = toId;
        this.date = date;
        this.action = action;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        flags = 0;
        flags = unread ? (flags | 1) : (flags &~ 1);
        flags = out ? (flags | 2) : (flags &~ 2);
        flags = mentioned ? (flags | 16) : (flags &~ 16);
        flags = mediaUnread ? (flags | 32) : (flags &~ 32);
        flags = fromId != null ? (flags | 256) : (flags &~ 256);

        writeInt(flags, stream);
        if ((flags & 1) != 0) writeBoolean(unread, stream);
        if ((flags & 2) != 0) writeBoolean(out, stream);
        if ((flags & 16) != 0) writeBoolean(mentioned, stream);
        if ((flags & 32) != 0) writeBoolean(mediaUnread, stream);
        writeInt(id, stream);
        if ((flags & 256) != 0) writeInt(fromId, stream);
        writeTLObject(toId, stream);
        writeInt(date, stream);
        writeTLObject(action, stream);
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
        date = readInt(stream);
        action = (com.github.badoualy.telegram.tl.api.TLAbsMessageAction) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "messageService#c06b9607";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TLAbsMessageAction getAction() {
        return action;
    }

    public void setAction(TLAbsMessageAction action) {
        this.action = action;
    }
}
