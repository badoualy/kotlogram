package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChatParticipants extends TLAbsChatParticipants {
    public static final int CONSTRUCTOR_ID = 0x3f460fed;

    protected TLVector<? extends TLAbsChatParticipant> participants;

    protected int version;

    public TLChatParticipants() {
    }

    public TLChatParticipants(int chatId, TLVector<? extends TLAbsChatParticipant> participants, int version) {
        this.chatId = chatId;
        this.participants = participants;
        this.version = version;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(chatId, stream);
        writeTLVector(participants, stream);
        writeInt(version, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        chatId = readInt(stream);
        participants = readTLVector(stream, context);
        version = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += participants.computeSerializedSize();
        size += SIZE_INT32;
        return size;
    }

    @Override
    public String toString() {
        return "chatParticipants#3f460fed";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLChatParticipants)) return false;
        if (object == this) return true;

        TLChatParticipants o = (TLChatParticipants) object;

        return chatId == o.chatId
                && (participants == o.participants || (participants != null && o.participants != null && participants.equals(o.participants)))
                && version == o.version;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public TLVector<? extends TLAbsChatParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(TLVector<? extends TLAbsChatParticipant> participants) {
        this.participants = participants;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
