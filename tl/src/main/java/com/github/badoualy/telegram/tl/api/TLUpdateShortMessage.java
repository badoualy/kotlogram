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
public class TLUpdateShortMessage extends TLAbsUpdates {

    public static final int CONSTRUCTOR_ID = 0x914fbf11;

    protected int flags;

    protected boolean out;

    protected boolean mentioned;

    protected boolean mediaUnread;

    protected boolean silent;

    protected int id;

    protected int userId;

    protected String message;

    protected int pts;

    protected int ptsCount;

    protected int date;

    protected TLMessageFwdHeader fwdFrom;

    protected Integer viaBotId;

    protected Integer replyToMsgId;

    protected TLVector<TLAbsMessageEntity> entities;

    private final String _constructor = "updateShortMessage#914fbf11";

    public TLUpdateShortMessage() {
    }

    public TLUpdateShortMessage(boolean out, boolean mentioned, boolean mediaUnread, boolean silent, int id, int userId, String message, int pts, int ptsCount, int date, TLMessageFwdHeader fwdFrom, Integer viaBotId, Integer replyToMsgId, TLVector<TLAbsMessageEntity> entities) {
        this.out = out;
        this.mentioned = mentioned;
        this.mediaUnread = mediaUnread;
        this.silent = silent;
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.pts = pts;
        this.ptsCount = ptsCount;
        this.date = date;
        this.fwdFrom = fwdFrom;
        this.viaBotId = viaBotId;
        this.replyToMsgId = replyToMsgId;
        this.entities = entities;
    }

    private void computeFlags() {
        flags = 0;
        flags = out ? (flags | 2) : (flags & ~2);
        flags = mentioned ? (flags | 16) : (flags & ~16);
        flags = mediaUnread ? (flags | 32) : (flags & ~32);
        flags = silent ? (flags | 8192) : (flags & ~8192);
        flags = fwdFrom != null ? (flags | 4) : (flags & ~4);
        flags = viaBotId != null ? (flags | 2048) : (flags & ~2048);
        flags = replyToMsgId != null ? (flags | 8) : (flags & ~8);
        flags = entities != null ? (flags | 128) : (flags & ~128);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(id, stream);
        writeInt(userId, stream);
        writeString(message, stream);
        writeInt(pts, stream);
        writeInt(ptsCount, stream);
        writeInt(date, stream);
        if ((flags & 4) != 0) {
            if (fwdFrom == null) throwNullFieldException("fwdFrom", flags);
            writeTLObject(fwdFrom, stream);
        }
        if ((flags & 2048) != 0) {
            if (viaBotId == null) throwNullFieldException("viaBotId", flags);
            writeInt(viaBotId, stream);
        }
        if ((flags & 8) != 0) {
            if (replyToMsgId == null) throwNullFieldException("replyToMsgId", flags);
            writeInt(replyToMsgId, stream);
        }
        if ((flags & 128) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            writeTLVector(entities, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        out = (flags & 2) != 0;
        mentioned = (flags & 16) != 0;
        mediaUnread = (flags & 32) != 0;
        silent = (flags & 8192) != 0;
        id = readInt(stream);
        userId = readInt(stream);
        message = readTLString(stream);
        pts = readInt(stream);
        ptsCount = readInt(stream);
        date = readInt(stream);
        fwdFrom = (flags & 4) != 0 ? readTLObject(stream, context, TLMessageFwdHeader.class,
                                                  TLMessageFwdHeader.CONSTRUCTOR_ID) : null;
        viaBotId = (flags & 2048) != 0 ? readInt(stream) : null;
        replyToMsgId = (flags & 8) != 0 ? readInt(stream) : null;
        entities = (flags & 128) != 0 ? readTLVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(message);
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 4) != 0) {
            if (fwdFrom == null) throwNullFieldException("fwdFrom", flags);
            size += fwdFrom.computeSerializedSize();
        }
        if ((flags & 2048) != 0) {
            if (viaBotId == null) throwNullFieldException("viaBotId", flags);
            size += SIZE_INT32;
        }
        if ((flags & 8) != 0) {
            if (replyToMsgId == null) throwNullFieldException("replyToMsgId", flags);
            size += SIZE_INT32;
        }
        if ((flags & 128) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            size += entities.computeSerializedSize();
        }
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

    public boolean getSilent() {
        return silent;
    }

    public void setSilent(boolean silent) {
        this.silent = silent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public TLMessageFwdHeader getFwdFrom() {
        return fwdFrom;
    }

    public void setFwdFrom(TLMessageFwdHeader fwdFrom) {
        this.fwdFrom = fwdFrom;
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

    public TLVector<TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(TLVector<TLAbsMessageEntity> entities) {
        this.entities = entities;
    }
}
