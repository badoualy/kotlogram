package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

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
public class TLDialog extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x66ffba14;

    protected int flags;

    protected boolean pinned;

    protected TLAbsPeer peer;

    protected int topMessage;

    protected int readInboxMaxId;

    protected int readOutboxMaxId;

    protected int unreadCount;

    protected TLAbsPeerNotifySettings notifySettings;

    protected Integer pts;

    protected TLAbsDraftMessage draft;

    private final String _constructor = "dialog#66ffba14";

    public TLDialog() {
    }

    public TLDialog(boolean pinned, TLAbsPeer peer, int topMessage, int readInboxMaxId, int readOutboxMaxId, int unreadCount, TLAbsPeerNotifySettings notifySettings, Integer pts, TLAbsDraftMessage draft) {
        this.pinned = pinned;
        this.peer = peer;
        this.topMessage = topMessage;
        this.readInboxMaxId = readInboxMaxId;
        this.readOutboxMaxId = readOutboxMaxId;
        this.unreadCount = unreadCount;
        this.notifySettings = notifySettings;
        this.pts = pts;
        this.draft = draft;
    }

    private void computeFlags() {
        flags = 0;
        flags = pinned ? (flags | 4) : (flags & ~4);
        flags = pts != null ? (flags | 1) : (flags & ~1);
        flags = draft != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeInt(topMessage, stream);
        writeInt(readInboxMaxId, stream);
        writeInt(readOutboxMaxId, stream);
        writeInt(unreadCount, stream);
        writeTLObject(notifySettings, stream);
        if ((flags & 1) != 0) {
            if (pts == null) throwNullFieldException("pts", flags);
            writeInt(pts, stream);
        }
        if ((flags & 2) != 0) {
            if (draft == null) throwNullFieldException("draft", flags);
            writeTLObject(draft, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        pinned = (flags & 4) != 0;
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        topMessage = readInt(stream);
        readInboxMaxId = readInt(stream);
        readOutboxMaxId = readInt(stream);
        unreadCount = readInt(stream);
        notifySettings = readTLObject(stream, context, TLAbsPeerNotifySettings.class, -1);
        pts = (flags & 1) != 0 ? readInt(stream) : null;
        draft = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsDraftMessage.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += notifySettings.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (pts == null) throwNullFieldException("pts", flags);
            size += SIZE_INT32;
        }
        if ((flags & 2) != 0) {
            if (draft == null) throwNullFieldException("draft", flags);
            size += draft.computeSerializedSize();
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

    public boolean getPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
    }

    public int getTopMessage() {
        return topMessage;
    }

    public void setTopMessage(int topMessage) {
        this.topMessage = topMessage;
    }

    public int getReadInboxMaxId() {
        return readInboxMaxId;
    }

    public void setReadInboxMaxId(int readInboxMaxId) {
        this.readInboxMaxId = readInboxMaxId;
    }

    public int getReadOutboxMaxId() {
        return readOutboxMaxId;
    }

    public void setReadOutboxMaxId(int readOutboxMaxId) {
        this.readOutboxMaxId = readOutboxMaxId;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    public TLAbsPeerNotifySettings getNotifySettings() {
        return notifySettings;
    }

    public void setNotifySettings(TLAbsPeerNotifySettings notifySettings) {
        this.notifySettings = notifySettings;
    }

    public Integer getPts() {
        return pts;
    }

    public void setPts(Integer pts) {
        this.pts = pts;
    }

    public TLAbsDraftMessage getDraft() {
        return draft;
    }

    public void setDraft(TLAbsDraftMessage draft) {
        this.draft = draft;
    }
}
