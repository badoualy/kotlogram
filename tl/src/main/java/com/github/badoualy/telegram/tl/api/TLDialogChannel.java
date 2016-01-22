package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLDialogChannel extends TLAbsDialog {
    public static final int CLASS_ID = 0x5b8496b2;

    protected TLAbsPeer peer;

    protected int topMessage;

    protected int topImportantMessage;

    protected int readInboxMaxId;

    protected int unreadCount;

    protected int unreadImportantCount;

    protected TLAbsPeerNotifySettings notifySettings;

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
        peer = (com.github.badoualy.telegram.tl.api.TLAbsPeer) readTLObject(stream, context);
        topMessage = readInt(stream);
        topImportantMessage = readInt(stream);
        readInboxMaxId = readInt(stream);
        unreadCount = readInt(stream);
        unreadImportantCount = readInt(stream);
        notifySettings = (com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings) readTLObject(stream, context);
        pts = readInt(stream);
    }

    @Override
    public String toString() {
        return "dialogChannel#5b8496b2";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
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
