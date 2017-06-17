package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateBotCallbackQuery extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0xe73547e1;

    protected int flags;

    protected long queryId;

    protected int userId;

    protected TLAbsPeer peer;

    protected int msgId;

    protected long chatInstance;

    protected TLBytes data;

    protected String gameShortName;

    private final String _constructor = "updateBotCallbackQuery#e73547e1";

    public TLUpdateBotCallbackQuery() {
    }

    public TLUpdateBotCallbackQuery(long queryId, int userId, TLAbsPeer peer, int msgId, long chatInstance, TLBytes data, String gameShortName) {
        this.queryId = queryId;
        this.userId = userId;
        this.peer = peer;
        this.msgId = msgId;
        this.chatInstance = chatInstance;
        this.data = data;
        this.gameShortName = gameShortName;
    }

    private void computeFlags() {
        flags = 0;
        flags = data != null ? (flags | 1) : (flags & ~1);
        flags = gameShortName != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(queryId, stream);
        writeInt(userId, stream);
        writeTLObject(peer, stream);
        writeInt(msgId, stream);
        writeLong(chatInstance, stream);
        if ((flags & 1) != 0) {
            if (data == null) throwNullFieldException("data", flags);
            writeTLBytes(data, stream);
        }
        if ((flags & 2) != 0) {
            if (gameShortName == null) throwNullFieldException("gameShortName", flags);
            writeString(gameShortName, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        queryId = readLong(stream);
        userId = readInt(stream);
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        msgId = readInt(stream);
        chatInstance = readLong(stream);
        data = (flags & 1) != 0 ? readTLBytes(stream, context) : null;
        gameShortName = (flags & 2) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT64;
        if ((flags & 1) != 0) {
            if (data == null) throwNullFieldException("data", flags);
            size += computeTLBytesSerializedSize(data);
        }
        if ((flags & 2) != 0) {
            if (gameShortName == null) throwNullFieldException("gameShortName", flags);
            size += computeTLStringSerializedSize(gameShortName);
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

    public long getQueryId() {
        return queryId;
    }

    public void setQueryId(long queryId) {
        this.queryId = queryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public long getChatInstance() {
        return chatInstance;
    }

    public void setChatInstance(long chatInstance) {
        this.chatInstance = chatInstance;
    }

    public TLBytes getData() {
        return data;
    }

    public void setData(TLBytes data) {
        this.data = data;
    }

    public String getGameShortName() {
        return gameShortName;
    }

    public void setGameShortName(String gameShortName) {
        this.gameShortName = gameShortName;
    }
}
