package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChat extends TLAbsChat {

    public static final int CONSTRUCTOR_ID = 0xd91cdd54;

    protected int flags;

    protected boolean creator;

    protected boolean kicked;

    protected boolean left;

    protected boolean adminsEnabled;

    protected boolean admin;

    protected boolean deactivated;

    protected String title;

    protected TLAbsChatPhoto photo;

    protected int participantsCount;

    protected int date;

    protected int version;

    protected TLAbsInputChannel migratedTo;

    private final String _constructor = "chat#d91cdd54";

    public TLChat() {
    }

    public TLChat(boolean creator, boolean kicked, boolean left, boolean adminsEnabled, boolean admin, boolean deactivated, int id, String title, TLAbsChatPhoto photo, int participantsCount, int date, int version, TLAbsInputChannel migratedTo) {
        this.creator = creator;
        this.kicked = kicked;
        this.left = left;
        this.adminsEnabled = adminsEnabled;
        this.admin = admin;
        this.deactivated = deactivated;
        this.id = id;
        this.title = title;
        this.photo = photo;
        this.participantsCount = participantsCount;
        this.date = date;
        this.version = version;
        this.migratedTo = migratedTo;
    }

    private void computeFlags() {
        flags = 0;
        flags = creator ? (flags | 1) : (flags & ~1);
        flags = kicked ? (flags | 2) : (flags & ~2);
        flags = left ? (flags | 4) : (flags & ~4);
        flags = adminsEnabled ? (flags | 8) : (flags & ~8);
        flags = admin ? (flags | 16) : (flags & ~16);
        flags = deactivated ? (flags | 32) : (flags & ~32);
        flags = migratedTo != null ? (flags | 64) : (flags & ~64);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(id, stream);
        writeString(title, stream);
        writeTLObject(photo, stream);
        writeInt(participantsCount, stream);
        writeInt(date, stream);
        writeInt(version, stream);
        if ((flags & 64) != 0) {
            if (migratedTo == null) throwNullFieldException("migratedTo", flags);
            writeTLObject(migratedTo, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        creator = (flags & 1) != 0;
        kicked = (flags & 2) != 0;
        left = (flags & 4) != 0;
        adminsEnabled = (flags & 8) != 0;
        admin = (flags & 16) != 0;
        deactivated = (flags & 32) != 0;
        id = readInt(stream);
        title = readTLString(stream);
        photo = readTLObject(stream, context, TLAbsChatPhoto.class, -1);
        participantsCount = readInt(stream);
        date = readInt(stream);
        version = readInt(stream);
        migratedTo = (flags & 64) != 0 ? readTLObject(stream, context, TLAbsInputChannel.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(title);
        size += photo.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 64) != 0) {
            if (migratedTo == null) throwNullFieldException("migratedTo", flags);
            size += migratedTo.computeSerializedSize();
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

    public boolean getCreator() {
        return creator;
    }

    public void setCreator(boolean creator) {
        this.creator = creator;
    }

    public boolean getKicked() {
        return kicked;
    }

    public void setKicked(boolean kicked) {
        this.kicked = kicked;
    }

    public boolean getLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean getAdminsEnabled() {
        return adminsEnabled;
    }

    public void setAdminsEnabled(boolean adminsEnabled) {
        this.adminsEnabled = adminsEnabled;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean getDeactivated() {
        return deactivated;
    }

    public void setDeactivated(boolean deactivated) {
        this.deactivated = deactivated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public TLAbsInputChannel getMigratedTo() {
        return migratedTo;
    }

    public void setMigratedTo(TLAbsInputChannel migratedTo) {
        this.migratedTo = migratedTo;
    }
}
