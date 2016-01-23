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
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUser extends TLAbsUser {
    public static final int CLASS_ID = 0xd10d979a;

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

    protected long accessHash;

    protected String firstName;

    protected String lastName;

    protected String username;

    protected String phone;

    protected TLAbsUserProfilePhoto photo;

    protected TLAbsUserStatus status;

    protected int botInfoVersion;

    protected String restrictionReason;

    protected String botInlinePlaceholder;

    public TLUser() {
    }

    public TLUser(int flags, boolean self, boolean contact, boolean mutualContact, boolean deleted, boolean bot, boolean botChatHistory, boolean botNochats, boolean verified, boolean restricted, int id, long accessHash, String firstName, String lastName, String username, String phone, TLAbsUserProfilePhoto photo, TLAbsUserStatus status, int botInfoVersion, String restrictionReason, String botInlinePlaceholder) {
        this.flags = flags;
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

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
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

        writeInt(flags, stream);
        if ((flags & 1024) != 0) writeTLBool(self, stream);
        if ((flags & 2048) != 0) writeTLBool(contact, stream);
        if ((flags & 4096) != 0) writeTLBool(mutualContact, stream);
        if ((flags & 8192) != 0) writeTLBool(deleted, stream);
        if ((flags & 16384) != 0) writeTLBool(bot, stream);
        if ((flags & 32768) != 0) writeTLBool(botChatHistory, stream);
        if ((flags & 65536) != 0) writeTLBool(botNochats, stream);
        if ((flags & 131072) != 0) writeTLBool(verified, stream);
        if ((flags & 262144) != 0) writeTLBool(restricted, stream);
        writeInt(id, stream);
        if ((flags & 1) != 0) writeLong(accessHash, stream);
        if ((flags & 2) != 0) writeTLString(firstName, stream);
        if ((flags & 4) != 0) writeTLString(lastName, stream);
        if ((flags & 8) != 0) writeTLString(username, stream);
        if ((flags & 16) != 0) writeTLString(phone, stream);
        if ((flags & 32) != 0) writeTLObject(photo, stream);
        if ((flags & 64) != 0) writeTLObject(status, stream);
        if ((flags & 16384) != 0) writeInt(botInfoVersion, stream);
        if ((flags & 262144) != 0) writeTLString(restrictionReason, stream);
        if ((flags & 524288) != 0) writeTLString(botInlinePlaceholder, stream);
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
        if ((flags & 1) != 0) accessHash = readLong(stream);
        if ((flags & 2) != 0) firstName = readTLString(stream);
        if ((flags & 4) != 0) lastName = readTLString(stream);
        if ((flags & 8) != 0) username = readTLString(stream);
        if ((flags & 16) != 0) phone = readTLString(stream);
        if ((flags & 32) != 0) photo = (com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto) readTLObject(stream, context);
        if ((flags & 64) != 0) status = (com.github.badoualy.telegram.tl.api.TLAbsUserStatus) readTLObject(stream, context);
        if ((flags & 16384) != 0) botInfoVersion = readInt(stream);
        if ((flags & 262144) != 0) restrictionReason = readTLString(stream);
        if ((flags & 524288) != 0) botInlinePlaceholder = readTLString(stream);
    }

    @Override
    public String toString() {
        return "user#d10d979a";
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

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long accessHash) {
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

    public int getBotInfoVersion() {
        return botInfoVersion;
    }

    public void setBotInfoVersion(int botInfoVersion) {
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
}
