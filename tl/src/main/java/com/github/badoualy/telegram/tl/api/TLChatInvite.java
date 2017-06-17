package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChatInvite extends TLAbsChatInvite {

    public static final int CONSTRUCTOR_ID = 0xdb74f558;

    protected int flags;

    protected boolean channel;

    protected boolean broadcast;

    protected boolean _public;

    protected boolean megagroup;

    protected String title;

    protected TLAbsChatPhoto photo;

    protected int participantsCount;

    protected TLVector<TLAbsUser> participants;

    private final String _constructor = "chatInvite#db74f558";

    public TLChatInvite() {
    }

    public TLChatInvite(boolean channel, boolean broadcast, boolean _public, boolean megagroup, String title, TLAbsChatPhoto photo, int participantsCount, TLVector<TLAbsUser> participants) {
        this.channel = channel;
        this.broadcast = broadcast;
        this._public = _public;
        this.megagroup = megagroup;
        this.title = title;
        this.photo = photo;
        this.participantsCount = participantsCount;
        this.participants = participants;
    }

    private void computeFlags() {
        flags = 0;
        flags = channel ? (flags | 1) : (flags & ~1);
        flags = broadcast ? (flags | 2) : (flags & ~2);
        flags = _public ? (flags | 4) : (flags & ~4);
        flags = megagroup ? (flags | 8) : (flags & ~8);
        flags = participants != null ? (flags | 16) : (flags & ~16);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(title, stream);
        writeTLObject(photo, stream);
        writeInt(participantsCount, stream);
        if ((flags & 16) != 0) {
            if (participants == null) throwNullFieldException("participants", flags);
            writeTLVector(participants, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        channel = (flags & 1) != 0;
        broadcast = (flags & 2) != 0;
        _public = (flags & 4) != 0;
        megagroup = (flags & 8) != 0;
        title = readTLString(stream);
        photo = readTLObject(stream, context, TLAbsChatPhoto.class, -1);
        participantsCount = readInt(stream);
        participants = (flags & 16) != 0 ? readTLVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(title);
        size += photo.computeSerializedSize();
        size += SIZE_INT32;
        if ((flags & 16) != 0) {
            if (participants == null) throwNullFieldException("participants", flags);
            size += participants.computeSerializedSize();
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

    public boolean getChannel() {
        return channel;
    }

    public void setChannel(boolean channel) {
        this.channel = channel;
    }

    public boolean getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(boolean broadcast) {
        this.broadcast = broadcast;
    }

    public boolean getPublic() {
        return _public;
    }

    public void setPublic(boolean _public) {
        this._public = _public;
    }

    public boolean getMegagroup() {
        return megagroup;
    }

    public void setMegagroup(boolean megagroup) {
        this.megagroup = megagroup;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TLAbsChatPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsChatPhoto photo) {
        this.photo = photo;
    }

    public int getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(int participantsCount) {
        this.participantsCount = participantsCount;
    }

    public TLVector<TLAbsUser> getParticipants() {
        return participants;
    }

    public void setParticipants(TLVector<TLAbsUser> participants) {
        this.participants = participants;
    }
}
