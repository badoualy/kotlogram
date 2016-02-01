package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelParticipantKicked extends TLAbsChannelParticipant {
    public static final int CONSTRUCTOR_ID = 0x8cc5e69a;

    protected int kickedBy;

    protected int date;

    public TLChannelParticipantKicked() {
    }

    public TLChannelParticipantKicked(int userId, int kickedBy, int date) {
        this.userId = userId;
        this.kickedBy = kickedBy;
        this.date = date;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(userId, stream);
        writeInt(kickedBy, stream);
        writeInt(date, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        userId = readInt(stream);
        kickedBy = readInt(stream);
        date = readInt(stream);
    }

    @Override
    public String toString() {
        return "channelParticipantKicked#8cc5e69a";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getKickedBy() {
        return kickedBy;
    }

    public void setKickedBy(int kickedBy) {
        this.kickedBy = kickedBy;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
