package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsMessageEntity;
import com.github.badoualy.telegram.tl.api.TLAbsReplyMarkup;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeBoolean;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesSendMessage extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0xfa88427a;

    protected int flags;

    protected boolean noWebpage;

    protected boolean broadcast;

    protected TLAbsInputPeer peer;

    protected int replyToMsgId;

    protected String message;

    protected long randomId;

    protected TLAbsReplyMarkup replyMarkup;

    protected TLVector<TLAbsMessageEntity> entities;

    public TLRequestMessagesSendMessage() {
    }

    public TLRequestMessagesSendMessage(int flags, boolean noWebpage, boolean broadcast, TLAbsInputPeer peer, int replyToMsgId, String message, long randomId, TLAbsReplyMarkup replyMarkup, TLVector<TLAbsMessageEntity> entities) {
        this.flags = flags;
        this.noWebpage = noWebpage;
        this.broadcast = broadcast;
        this.peer = peer;
        this.replyToMsgId = replyToMsgId;
        this.message = message;
        this.randomId = randomId;
        this.replyMarkup = replyMarkup;
        this.entities = entities;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUpdates)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsUpdates) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        flags = 0;
        flags = noWebpage ? (flags | 2) : (flags &~ 2);
        flags = broadcast ? (flags | 16) : (flags &~ 16);
        flags = replyToMsgId != null ? (flags | 1) : (flags &~ 1);
        flags = replyMarkup != null ? (flags | 4) : (flags &~ 4);
        flags = entities != null ? (flags | 8) : (flags &~ 8);

        writeInt(flags, stream);
        if ((flags & 2) != 0) writeBoolean(noWebpage, stream);
        if ((flags & 16) != 0) writeBoolean(broadcast, stream);
        writeTLObject(peer, stream);
        if ((flags & 1) != 0) writeInt(replyToMsgId, stream);
        writeString(message, stream);
        writeLong(randomId, stream);
        if ((flags & 4) != 0) writeTLObject(replyMarkup, stream);
        if ((flags & 8) != 0) writeTLVector(entities, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        noWebpage = (flags & 2) != 0;
        broadcast = (flags & 16) != 0;
        peer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer) readTLObject(stream, context);
        if ((flags & 1) != 0) replyToMsgId = readInt(stream);
        message = readTLString(stream);
        randomId = readLong(stream);
        if ((flags & 4) != 0) replyMarkup = (com.github.badoualy.telegram.tl.api.TLAbsReplyMarkup) readTLObject(stream, context);
        if ((flags & 8) != 0) entities = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "messages.sendMessage#fa88427a";
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

    public boolean getNoWebpage() {
        return noWebpage;
    }

    public void setNoWebpage(boolean noWebpage) {
        this.noWebpage = noWebpage;
    }

    public boolean getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(boolean broadcast) {
        this.broadcast = broadcast;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public int getReplyToMsgId() {
        return replyToMsgId;
    }

    public void setReplyToMsgId(int replyToMsgId) {
        this.replyToMsgId = replyToMsgId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long randomId) {
        this.randomId = randomId;
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
}
