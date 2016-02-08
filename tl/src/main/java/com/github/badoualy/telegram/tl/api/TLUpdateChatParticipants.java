package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateChatParticipants extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x7761198;

    protected TLAbsChatParticipants participants;

    public TLUpdateChatParticipants() {
    }

    public TLUpdateChatParticipants(TLAbsChatParticipants participants) {
        this.participants = participants;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(participants, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        participants = (TLAbsChatParticipants) readTLObject(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += participants.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "updateChatParticipants#7761198";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLAbsChatParticipants getParticipants() {
        return participants;
    }

    public void setParticipants(TLAbsChatParticipants participants) {
        this.participants = participants;
    }
}
