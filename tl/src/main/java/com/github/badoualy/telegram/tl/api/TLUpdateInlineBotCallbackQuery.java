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
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateInlineBotCallbackQuery extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x2cbd95af;

    protected long queryId;

    protected int userId;

    protected TLInputBotInlineMessageID msgId;

    protected TLBytes data;

    private final String _constructor = "updateInlineBotCallbackQuery#2cbd95af";

    public TLUpdateInlineBotCallbackQuery() {
    }

    public TLUpdateInlineBotCallbackQuery(long queryId, int userId, TLInputBotInlineMessageID msgId, TLBytes data) {
        this.queryId = queryId;
        this.userId = userId;
        this.msgId = msgId;
        this.data = data;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(queryId, stream);
        writeInt(userId, stream);
        writeTLObject(msgId, stream);
        writeTLBytes(data, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        queryId = readLong(stream);
        userId = readInt(stream);
        msgId = readTLObject(stream, context, TLInputBotInlineMessageID.class, TLInputBotInlineMessageID.CONSTRUCTOR_ID);
        data = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += msgId.computeSerializedSize();
        size += computeTLBytesSerializedSize(data);
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

    public TLInputBotInlineMessageID getMsgId() {
        return msgId;
    }

    public void setMsgId(TLInputBotInlineMessageID msgId) {
        this.msgId = msgId;
    }

    public TLBytes getData() {
        return data;
    }

    public void setData(TLBytes data) {
        this.data = data;
    }
}
