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
public class TLChannel extends TLAbsChat {
    public static final int CLASS_ID = 0x4b1b7506;

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

    protected long accessHash;

    protected String title;

    protected String username;

    protected TLAbsChatPhoto photo;

    protected int date;

    protected int version;

    protected String restrictionReason;

    public TLChannel() {
    }

    public TLChannel(int flags, boolean creator, boolean kicked, boolean left, boolean editor, boolean moderator, boolean broadcast, boolean verified, boolean megagroup, boolean restricted, int id, long accessHash, String title, String username, TLAbsChatPhoto photo, int date, int version, String restrictionReason) {
        this.flags = flags;
        this.creator = creator;
        this.kicked = kicked;
        this.left = left;
        this.editor = editor;
        this.moderator = moderator;
        this.broadcast = broadcast;
        this.verified = verified;
        this.megagroup = megagroup;
        this.restricted = restricted;
        this.id = id;
        this.accessHash = accessHash;
        this.title = title;
        this.username = username;
        this.photo = photo;
        this.date = date;
        this.version = version;
        this.restrictionReason = restrictionReason;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(flags, stream);
        if ((flags & 1) != 0) writeTLBool(creator, stream);
        if ((flags & 2) != 0) writeTLBool(kicked, stream);
        if ((flags & 4) != 0) writeTLBool(left, stream);
        if ((flags & 8) != 0) writeTLBool(editor, stream);
        if ((flags & 16) != 0) writeTLBool(moderator, stream);
        if ((flags & 32) != 0) writeTLBool(broadcast, stream);
        if ((flags & 128) != 0) writeTLBool(verified, stream);
        if ((flags & 256) != 0) writeTLBool(megagroup, stream);
        if ((flags & 512) != 0) writeTLBool(restricted, stream);
        writeInt(id, stream);
        writeLong(accessHash, stream);
        writeTLString(title, stream);
        if ((flags & 64) != 0) writeTLString(username, stream);
        writeTLObject(photo, stream);
        writeInt(date, stream);
        writeInt(version, stream);
        if ((flags & 512) != 0) writeTLString(restrictionReason, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
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
        id = readInt(stream);
        accessHash = readLong(stream);
        title = readTLString(stream);
        if ((flags & 64) != 0) username = readTLString(stream);
        photo = (com.github.badoualy.telegram.tl.api.TLAbsChatPhoto) readTLObject(stream, context);
        date = readInt(stream);
        version = readInt(stream);
        if ((flags & 512) != 0) restrictionReason = readTLString(stream);
    }

    @Override
    public String toString() {
        return "channel#4b1b7506";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long accessHash) {
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
