package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannel extends TLAbsChat {

    public static final int CONSTRUCTOR_ID = 0xa14dca52;

    protected int flags;

    protected boolean creator;

    protected boolean kicked;

    protected boolean left;

    protected boolean editor;

    protected boolean moderator;

    protected boolean broadcast;

    protected boolean verified;

    protected boolean megagroup;

    protected boolean restricted;

    protected boolean democracy;

    protected boolean signatures;

    protected boolean min;

    protected Long accessHash;

    protected String title;

    protected String username;

    protected TLAbsChatPhoto photo;

    protected int date;

    protected int version;

    protected String restrictionReason;

    private final String _constructor = "channel#a14dca52";

    public TLChannel() {
    }

    public TLChannel(boolean creator, boolean kicked, boolean left, boolean editor, boolean moderator, boolean broadcast, boolean verified, boolean megagroup, boolean restricted, boolean democracy, boolean signatures, boolean min, int id, Long accessHash, String title, String username, TLAbsChatPhoto photo, int date, int version, String restrictionReason) {
        this.creator = creator;
        this.kicked = kicked;
        this.left = left;
        this.editor = editor;
        this.moderator = moderator;
        this.broadcast = broadcast;
        this.verified = verified;
        this.megagroup = megagroup;
        this.restricted = restricted;
        this.democracy = democracy;
        this.signatures = signatures;
        this.min = min;
        this.id = id;
        this.accessHash = accessHash;
        this.title = title;
        this.username = username;
        this.photo = photo;
        this.date = date;
        this.version = version;
        this.restrictionReason = restrictionReason;
    }

    private void computeFlags() {
        flags = 0;
        flags = creator ? (flags | 1) : (flags & ~1);
        flags = kicked ? (flags | 2) : (flags & ~2);
        flags = left ? (flags | 4) : (flags & ~4);
        flags = editor ? (flags | 8) : (flags & ~8);
        flags = moderator ? (flags | 16) : (flags & ~16);
        flags = broadcast ? (flags | 32) : (flags & ~32);
        flags = verified ? (flags | 128) : (flags & ~128);
        flags = megagroup ? (flags | 256) : (flags & ~256);
        flags = restricted ? (flags | 512) : (flags & ~512);
        flags = democracy ? (flags | 1024) : (flags & ~1024);
        flags = signatures ? (flags | 2048) : (flags & ~2048);
        flags = min ? (flags | 4096) : (flags & ~4096);
        flags = accessHash != null ? (flags | 8192) : (flags & ~8192);
        flags = username != null ? (flags | 64) : (flags & ~64);
        flags = restrictionReason != null ? (flags | 512) : (flags & ~512);

        // Following parameters might be forced to true by another field that updated the flags
        restricted = (flags & 512) != 0;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(id, stream);
        if ((flags & 8192) != 0) {
            if (accessHash == null) throwNullFieldException("accessHash", flags);
            writeLong(accessHash, stream);
        }
        writeString(title, stream);
        if ((flags & 64) != 0) {
            if (username == null) throwNullFieldException("username", flags);
            writeString(username, stream);
        }
        writeTLObject(photo, stream);
        writeInt(date, stream);
        writeInt(version, stream);
        if ((flags & 512) != 0) {
            if (restrictionReason == null) throwNullFieldException("restrictionReason", flags);
            writeString(restrictionReason, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        creator = (flags & 1) != 0;
        kicked = (flags & 2) != 0;
        left = (flags & 4) != 0;
        editor = (flags & 8) != 0;
        moderator = (flags & 16) != 0;
        broadcast = (flags & 32) != 0;
        verified = (flags & 128) != 0;
        megagroup = (flags & 256) != 0;
        restricted = (flags & 512) != 0;
        democracy = (flags & 1024) != 0;
        signatures = (flags & 2048) != 0;
        min = (flags & 4096) != 0;
        id = readInt(stream);
        accessHash = (flags & 8192) != 0 ? readLong(stream) : null;
        title = readTLString(stream);
        username = (flags & 64) != 0 ? readTLString(stream) : null;
        photo = readTLObject(stream, context, TLAbsChatPhoto.class, -1);
        date = readInt(stream);
        version = readInt(stream);
        restrictionReason = (flags & 512) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 8192) != 0) {
            if (accessHash == null) throwNullFieldException("accessHash", flags);
            size += SIZE_INT64;
        }
        size += computeTLStringSerializedSize(title);
        if ((flags & 64) != 0) {
            if (username == null) throwNullFieldException("username", flags);
            size += computeTLStringSerializedSize(username);
        }
        size += photo.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 512) != 0) {
            if (restrictionReason == null) throwNullFieldException("restrictionReason", flags);
            size += computeTLStringSerializedSize(restrictionReason);
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

    public boolean getEditor() {
        return editor;
    }

    public void setEditor(boolean editor) {
        this.editor = editor;
    }

    public boolean getModerator() {
        return moderator;
    }

    public void setModerator(boolean moderator) {
        this.moderator = moderator;
    }

    public boolean getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(boolean broadcast) {
        this.broadcast = broadcast;
    }

    public boolean getVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public boolean getMegagroup() {
        return megagroup;
    }

    public void setMegagroup(boolean megagroup) {
        this.megagroup = megagroup;
    }

    public boolean getRestricted() {
        return restricted;
    }

    public void setRestricted(boolean restricted) {
        this.restricted = restricted;
    }

    public boolean getDemocracy() {
        return democracy;
    }

    public void setDemocracy(boolean democracy) {
        this.democracy = democracy;
    }

    public boolean getSignatures() {
        return signatures;
    }

    public void setSignatures(boolean signatures) {
        this.signatures = signatures;
    }

    public boolean getMin() {
        return min;
    }

    public void setMin(boolean min) {
        this.min = min;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(Long accessHash) {
        this.accessHash = accessHash;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TLAbsChatPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsChatPhoto photo) {
        this.photo = photo;
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

    public String getRestrictionReason() {
        return restrictionReason;
    }

    public void setRestrictionReason(String restrictionReason) {
        this.restrictionReason = restrictionReason;
    }
}
