package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeBoolean;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUser extends TLAbsUser {
    public static final int CONSTRUCTOR_ID = 0xd10d979a;

    protected int flags;

    protected boolean self;

    protected boolean contact;

    protected boolean mutualContact;

    protected boolean deleted;

    protected boolean bot;

    protected boolean botChatHistory;

    protected boolean botNochats;

    protected boolean verified;

    protected boolean restricted;

    protected Long accessHash;

    protected String firstName;

    protected String lastName;

    protected String username;

    protected String phone;

    protected TLAbsUserProfilePhoto photo;

    protected TLAbsUserStatus status;

    protected Integer botInfoVersion;

    protected String restrictionReason;

    protected String botInlinePlaceholder;

    public TLUser() {
    }

    public TLUser(boolean self, boolean contact, boolean mutualContact, boolean deleted, boolean bot, boolean botChatHistory, boolean botNochats, boolean verified, boolean restricted, int id, Long accessHash, String firstName, String lastName, String username, String phone, TLAbsUserProfilePhoto photo, TLAbsUserStatus status, Integer botInfoVersion, String restrictionReason, String botInlinePlaceholder) {
        this.self = self;
        this.contact = contact;
        this.mutualContact = mutualContact;
        this.deleted = deleted;
        this.bot = bot;
        this.botChatHistory = botChatHistory;
        this.botNochats = botNochats;
        this.verified = verified;
        this.restricted = restricted;
        this.id = id;
        this.accessHash = accessHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.phone = phone;
        this.photo = photo;
        this.status = status;
        this.botInfoVersion = botInfoVersion;
        this.restrictionReason = restrictionReason;
        this.botInlinePlaceholder = botInlinePlaceholder;
    }

    private void computeFlags() {
        flags = 0;
        flags = self ? (flags | 1024) : (flags &~ 1024);
        flags = contact ? (flags | 2048) : (flags &~ 2048);
        flags = mutualContact ? (flags | 4096) : (flags &~ 4096);
        flags = deleted ? (flags | 8192) : (flags &~ 8192);
        flags = bot ? (flags | 16384) : (flags &~ 16384);
        flags = botChatHistory ? (flags | 32768) : (flags &~ 32768);
        flags = botNochats ? (flags | 65536) : (flags &~ 65536);
        flags = verified ? (flags | 131072) : (flags &~ 131072);
        flags = restricted ? (flags | 262144) : (flags &~ 262144);
        flags = accessHash != null ? (flags | 1) : (flags &~ 1);
        flags = firstName != null ? (flags | 2) : (flags &~ 2);
        flags = lastName != null ? (flags | 4) : (flags &~ 4);
        flags = username != null ? (flags | 8) : (flags &~ 8);
        flags = phone != null ? (flags | 16) : (flags &~ 16);
        flags = photo != null ? (flags | 32) : (flags &~ 32);
        flags = status != null ? (flags | 64) : (flags &~ 64);
        flags = botInfoVersion != null ? (flags | 16384) : (flags &~ 16384);
        flags = restrictionReason != null ? (flags | 262144) : (flags &~ 262144);
        flags = botInlinePlaceholder != null ? (flags | 524288) : (flags &~ 524288);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1024) != 0) writeBoolean(self, stream);
        if ((flags & 2048) != 0) writeBoolean(contact, stream);
        if ((flags & 4096) != 0) writeBoolean(mutualContact, stream);
        if ((flags & 8192) != 0) writeBoolean(deleted, stream);
        if ((flags & 16384) != 0) writeBoolean(bot, stream);
        if ((flags & 32768) != 0) writeBoolean(botChatHistory, stream);
        if ((flags & 65536) != 0) writeBoolean(botNochats, stream);
        if ((flags & 131072) != 0) writeBoolean(verified, stream);
        if ((flags & 262144) != 0) writeBoolean(restricted, stream);
        writeInt(id, stream);
        if ((flags & 1) != 0) writeLong(accessHash, stream);
        if ((flags & 2) != 0) writeString(firstName, stream);
        if ((flags & 4) != 0) writeString(lastName, stream);
        if ((flags & 8) != 0) writeString(username, stream);
        if ((flags & 16) != 0) writeString(phone, stream);
        if ((flags & 32) != 0) writeTLObject(photo, stream);
        if ((flags & 64) != 0) writeTLObject(status, stream);
        if ((flags & 16384) != 0) writeInt(botInfoVersion, stream);
        if ((flags & 262144) != 0) writeString(restrictionReason, stream);
        if ((flags & 524288) != 0) writeString(botInlinePlaceholder, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        self = (flags & 1024) != 0;
        contact = (flags & 2048) != 0;
        mutualContact = (flags & 4096) != 0;
        deleted = (flags & 8192) != 0;
        bot = (flags & 16384) != 0;
        botChatHistory = (flags & 32768) != 0;
        botNochats = (flags & 65536) != 0;
        verified = (flags & 131072) != 0;
        restricted = (flags & 262144) != 0;
        id = readInt(stream);
        accessHash = (flags & 1) != 0 ? readLong(stream) : null;
        firstName = (flags & 2) != 0 ? readTLString(stream) : null;
        lastName = (flags & 4) != 0 ? readTLString(stream) : null;
        username = (flags & 8) != 0 ? readTLString(stream) : null;
        phone = (flags & 16) != 0 ? readTLString(stream) : null;
        photo = (flags & 32) != 0 ? readTLObject(stream, context, TLAbsUserProfilePhoto.class, -1) : null;
        status = (flags & 64) != 0 ? readTLObject(stream, context, TLAbsUserStatus.class, -1) : null;
        botInfoVersion = (flags & 16384) != 0 ? readInt(stream) : null;
        restrictionReason = (flags & 262144) != 0 ? readTLString(stream) : null;
        botInlinePlaceholder = (flags & 524288) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1024) != 0) size += SIZE_BOOLEAN;
        if ((flags & 2048) != 0) size += SIZE_BOOLEAN;
        if ((flags & 4096) != 0) size += SIZE_BOOLEAN;
        if ((flags & 8192) != 0) size += SIZE_BOOLEAN;
        if ((flags & 16384) != 0) size += SIZE_BOOLEAN;
        if ((flags & 32768) != 0) size += SIZE_BOOLEAN;
        if ((flags & 65536) != 0) size += SIZE_BOOLEAN;
        if ((flags & 131072) != 0) size += SIZE_BOOLEAN;
        if ((flags & 262144) != 0) size += SIZE_BOOLEAN;
        size += SIZE_INT32;
        if ((flags & 1) != 0) size += SIZE_INT64;
        if ((flags & 2) != 0) size += computeTLStringSerializedSize(firstName);
        if ((flags & 4) != 0) size += computeTLStringSerializedSize(lastName);
        if ((flags & 8) != 0) size += computeTLStringSerializedSize(username);
        if ((flags & 16) != 0) size += computeTLStringSerializedSize(phone);
        if ((flags & 32) != 0) size += photo.computeSerializedSize();
        if ((flags & 64) != 0) size += status.computeSerializedSize();
        if ((flags & 16384) != 0) size += SIZE_INT32;
        if ((flags & 262144) != 0) size += computeTLStringSerializedSize(restrictionReason);
        if ((flags & 524288) != 0) size += computeTLStringSerializedSize(botInlinePlaceholder);
        return size;
    }

    @Override
    public String toString() {
        return "user#d10d979a";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public boolean getSelf() {
        return self;
    }

    public void setSelf(boolean self) {
        this.self = self;
    }

    public boolean getContact() {
        return contact;
    }

    public void setContact(boolean contact) {
        this.contact = contact;
    }

    public boolean getMutualContact() {
        return mutualContact;
    }

    public void setMutualContact(boolean mutualContact) {
        this.mutualContact = mutualContact;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean getBot() {
        return bot;
    }

    public void setBot(boolean bot) {
        this.bot = bot;
    }

    public boolean getBotChatHistory() {
        return botChatHistory;
    }

    public void setBotChatHistory(boolean botChatHistory) {
        this.botChatHistory = botChatHistory;
    }

    public boolean getBotNochats() {
        return botNochats;
    }

    public void setBotNochats(boolean botNochats) {
        this.botNochats = botNochats;
    }

    public boolean getVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
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

    public Long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(Long accessHash) {
        this.accessHash = accessHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public TLAbsUserProfilePhoto getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsUserProfilePhoto photo) {
        this.photo = photo;
    }

    public TLAbsUserStatus getStatus() {
        return status;
    }

    public void setStatus(TLAbsUserStatus status) {
        this.status = status;
    }

    public Integer getBotInfoVersion() {
        return botInfoVersion;
    }

    public void setBotInfoVersion(Integer botInfoVersion) {
        this.botInfoVersion = botInfoVersion;
    }

    public String getRestrictionReason() {
        return restrictionReason;
    }

    public void setRestrictionReason(String restrictionReason) {
        this.restrictionReason = restrictionReason;
    }

    public String getBotInlinePlaceholder() {
        return botInlinePlaceholder;
    }

    public void setBotInlinePlaceholder(String botInlinePlaceholder) {
        this.botInlinePlaceholder = botInlinePlaceholder;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLUser getAsUser() {
        return this;
    }
}
