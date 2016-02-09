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
public class TLDialogChannel extends TLAbsDialog {
    public static final int CONSTRUCTOR_ID = 0x5b8496b2;

    protected int topImportantMessage;

    protected int unreadImportantCount;

    protected int pts;

    public TLDialogChannel() {
    }

    public TLDialogChannel(TLAbsPeer peer, int topMessage, int topImportantMessage, int readInboxMaxId, int unreadCount, int unreadImportantCount, TLAbsPeerNotifySettings notifySettings, int pts) {
        this.peer = peer;
        this.topMessage = topMessage;
        this.topImportantMessage = topImportantMessage;
        this.readInboxMaxId = readInboxMaxId;
        this.unreadCount = unreadCount;
        this.unreadImportantCount = unreadImportantCount;
        this.notifySettings = notifySettings;
        this.pts = pts;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peer, stream);
        writeInt(topMessage, stream);
        writeInt(topImportantMessage, stream);
        writeInt(readInboxMaxId, stream);
        writeInt(unreadCount, stream);
        writeInt(unreadImportantCount, stream);
        writeTLObject(notifySettings, stream);
        writeInt(pts, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        topMessage = readInt(stream);
        topImportantMessage = readInt(stream);
        readInboxMaxId = readInt(stream);
        unreadCount = readInt(stream);
        unreadImportantCount = readInt(stream);
        notifySettings = readTLObject(stream, context, TLAbsPeerNotifySettings.class, -1);
        pts = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += peer.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += notifySettings.computeSerializedSize();
        size += SIZE_INT32;
        return size;
    }

    @Override
    public String toString() {
        return "dialogChannel#5b8496b2";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLDialogChannel)) return false;
        if (object == this) return true;

        TLDialogChannel o = (TLDialogChannel) object;

        return (peer == o.peer || (peer != null && o.peer != null && peer.equals(o.peer)))
                && topMessage == o.topMessage
                && topImportantMessage == o.topImportantMessage
                && readInboxMaxId == o.readInboxMaxId
                && unreadCount == o.unreadCount
                && unreadImportantCount == o.unreadImportantCount
                && (notifySettings == o.notifySettings || (notifySettings != null && o.notifySettings != null && notifySettings.equals(o.notifySettings)))
                && pts == o.pts;
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

    public int getTopImportantMessage() {
        return topImportantMessage;
    }

    public void setTopImportantMessage(int topImportantMessage) {
        this.topImportantMessage = topImportantMessage;
    }

    public int getReadInboxMaxId() {
        return readInboxMaxId;
    }

    public void setReadInboxMaxId(int readInboxMaxId) {
        this.readInboxMaxId = readInboxMaxId;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    public int getUnreadImportantCount() {
        return unreadImportantCount;
    }

    public void setUnreadImportantCount(int unreadImportantCount) {
        this.unreadImportantCount = unreadImportantCount;
    }

    public TLAbsPeerNotifySettings getNotifySettings() {
        return notifySettings;
    }

    public void setNotifySettings(TLAbsPeerNotifySettings notifySettings) {
        this.notifySettings = notifySettings;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }
}
