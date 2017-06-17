package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageService extends TLAbsMessage {

    public static final int CONSTRUCTOR_ID = 0x9e19a1f6;

    protected int flags;

    protected boolean out;

    protected boolean mentioned;

    protected boolean mediaUnread;

    protected boolean silent;

    protected boolean post;

    protected Integer fromId;

    protected TLAbsPeer toId;

    protected Integer replyToMsgId;

    protected int date;

    protected TLAbsMessageAction action;

    private final String _constructor = "messageService#9e19a1f6";

    public TLMessageService() {
    }

    public TLMessageService(boolean out, boolean mentioned, boolean mediaUnread, boolean silent, boolean post, int id, Integer fromId, TLAbsPeer toId, Integer replyToMsgId, int date, TLAbsMessageAction action) {
        this.out = out;
        this.mentioned = mentioned;
        this.mediaUnread = mediaUnread;
        this.silent = silent;
        this.post = post;
        this.id = id;
        this.fromId = fromId;
        this.toId = toId;
        this.replyToMsgId = replyToMsgId;
        this.date = date;
        this.action = action;
    }

    private void computeFlags() {
        flags = 0;
        flags = out ? (flags | 2) : (flags & ~2);
        flags = mentioned ? (flags | 16) : (flags & ~16);
        flags = mediaUnread ? (flags | 32) : (flags & ~32);
        flags = silent ? (flags | 8192) : (flags & ~8192);
        flags = post ? (flags | 16384) : (flags & ~16384);
        flags = fromId != null ? (flags | 256) : (flags & ~256);
        flags = replyToMsgId != null ? (flags | 8) : (flags & ~8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(id, stream);
        if ((flags & 256) != 0) {
            if (fromId == null) throwNullFieldException("fromId", flags);
            writeInt(fromId, stream);
        }
        writeTLObject(toId, stream);
        if ((flags & 8) != 0) {
            if (replyToMsgId == null) throwNullFieldException("replyToMsgId", flags);
            writeInt(replyToMsgId, stream);
        }
        writeInt(date, stream);
        writeTLObject(action, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        out = (flags & 2) != 0;
        mentioned = (flags & 16) != 0;
        mediaUnread = (flags & 32) != 0;
        silent = (flags & 8192) != 0;
        post = (flags & 16384) != 0;
        id = readInt(stream);
        fromId = (flags & 256) != 0 ? readInt(stream) : null;
        toId = readTLObject(stream, context, TLAbsPeer.class, -1);
        replyToMsgId = (flags & 8) != 0 ? readInt(stream) : null;
        date = readInt(stream);
        action = readTLObject(stream, context, TLAbsMessageAction.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 256) != 0) {
            if (fromId == null) throwNullFieldException("fromId", flags);
            size += SIZE_INT32;
        }
        size += toId.computeSerializedSize();
        if ((flags & 8) != 0) {
            if (replyToMsgId == null) throwNullFieldException("replyToMsgId", flags);
            size += SIZE_INT32;
        }
        size += SIZE_INT32;
        size += action.computeSerializedSize();
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

    public boolean getPost() {
        return post;
    }

    public void setPost(boolean post) {
        this.post = post;
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

    public TLAbsMessageAction getAction() {
        return action;
    }

    public void setAction(TLAbsMessageAction action) {
        this.action = action;
    }
}
