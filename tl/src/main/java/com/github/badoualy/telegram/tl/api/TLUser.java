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
public class TLUser extends TLAbsUser {

    public static final int CONSTRUCTOR_ID = 0x2e13f4c3;

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

    protected boolean min;

    protected boolean botInlineGeo;

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

    protected String langCode;

    private final String _constructor = "user#2e13f4c3";

    public TLUser() {
    }

    public TLUser(boolean self, boolean contact, boolean mutualContact, boolean deleted, boolean bot, boolean botChatHistory, boolean botNochats, boolean verified, boolean restricted, boolean min, boolean botInlineGeo, int id, Long accessHash, String firstName, String lastName, String username, String phone, TLAbsUserProfilePhoto photo, TLAbsUserStatus status, Integer botInfoVersion, String restrictionReason, String botInlinePlaceholder, String langCode) {
        this.self = self;
        this.contact = contact;
        this.mutualContact = mutualContact;
        this.deleted = deleted;
        this.bot = bot;
        this.botChatHistory = botChatHistory;
        this.botNochats = botNochats;
        this.verified = verified;
        this.restricted = restricted;
        this.min = min;
        this.botInlineGeo = botInlineGeo;
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
        this.langCode = langCode;
    }

    private void computeFlags() {
        flags = 0;
        flags = self ? (flags | 1024) : (flags & ~1024);
        flags = contact ? (flags | 2048) : (flags & ~2048);
        flags = mutualContact ? (flags | 4096) : (flags & ~4096);
        flags = deleted ? (flags | 8192) : (flags & ~8192);
        flags = bot ? (flags | 16384) : (flags & ~16384);
        flags = botChatHistory ? (flags | 32768) : (flags & ~32768);
        flags = botNochats ? (flags | 65536) : (flags & ~65536);
        flags = verified ? (flags | 131072) : (flags & ~131072);
        flags = restricted ? (flags | 262144) : (flags & ~262144);
        flags = min ? (flags | 1048576) : (flags & ~1048576);
        flags = botInlineGeo ? (flags | 2097152) : (flags & ~2097152);
        flags = accessHash != null ? (flags | 1) : (flags & ~1);
        flags = firstName != null ? (flags | 2) : (flags & ~2);
        flags = lastName != null ? (flags | 4) : (flags & ~4);
        flags = username != null ? (flags | 8) : (flags & ~8);
        flags = phone != null ? (flags | 16) : (flags & ~16);
        flags = photo != null ? (flags | 32) : (flags & ~32);
        flags = status != null ? (flags | 64) : (flags & ~64);
        flags = botInfoVersion != null ? (flags | 16384) : (flags & ~16384);
        flags = restrictionReason != null ? (flags | 262144) : (flags & ~262144);
        flags = botInlinePlaceholder != null ? (flags | 524288) : (flags & ~524288);
        flags = langCode != null ? (flags | 4194304) : (flags & ~4194304);

        // Following parameters might be forced to true by another field that updated the flags
        bot = (flags & 16384) != 0;
        restricted = (flags & 262144) != 0;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(id, stream);
        if ((flags & 1) != 0) {
            if (accessHash == null) throwNullFieldException("accessHash", flags);
            writeLong(accessHash, stream);
        }
        if ((flags & 2) != 0) {
            if (firstName == null) throwNullFieldException("firstName", flags);
            writeString(firstName, stream);
        }
        if ((flags & 4) != 0) {
            if (lastName == null) throwNullFieldException("lastName", flags);
            writeString(lastName, stream);
        }
        if ((flags & 8) != 0) {
            if (username == null) throwNullFieldException("username", flags);
            writeString(username, stream);
        }
        if ((flags & 16) != 0) {
            if (phone == null) throwNullFieldException("phone", flags);
            writeString(phone, stream);
        }
        if ((flags & 32) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            writeTLObject(photo, stream);
        }
        if ((flags & 64) != 0) {
            if (status == null) throwNullFieldException("status", flags);
            writeTLObject(status, stream);
        }
        if ((flags & 16384) != 0) {
            if (botInfoVersion == null) throwNullFieldException("botInfoVersion", flags);
            writeInt(botInfoVersion, stream);
        }
        if ((flags & 262144) != 0) {
            if (restrictionReason == null) throwNullFieldException("restrictionReason", flags);
            writeString(restrictionReason, stream);
        }
        if ((flags & 524288) != 0) {
            if (botInlinePlaceholder == null) throwNullFieldException("botInlinePlaceholder", flags);
            writeString(botInlinePlaceholder, stream);
        }
        if ((flags & 4194304) != 0) {
            if (langCode == null) throwNullFieldException("langCode", flags);
            writeString(langCode, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
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
        min = (flags & 1048576) != 0;
        botInlineGeo = (flags & 2097152) != 0;
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
        langCode = (flags & 4194304) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (accessHash == null) throwNullFieldException("accessHash", flags);
            size += SIZE_INT64;
        }
        if ((flags & 2) != 0) {
            if (firstName == null) throwNullFieldException("firstName", flags);
            size += computeTLStringSerializedSize(firstName);
        }
        if ((flags & 4) != 0) {
            if (lastName == null) throwNullFieldException("lastName", flags);
            size += computeTLStringSerializedSize(lastName);
        }
        if ((flags & 8) != 0) {
            if (username == null) throwNullFieldException("username", flags);
            size += computeTLStringSerializedSize(username);
        }
        if ((flags & 16) != 0) {
            if (phone == null) throwNullFieldException("phone", flags);
            size += computeTLStringSerializedSize(phone);
        }
        if ((flags & 32) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            size += photo.computeSerializedSize();
        }
        if ((flags & 64) != 0) {
            if (status == null) throwNullFieldException("status", flags);
            size += status.computeSerializedSize();
        }
        if ((flags & 16384) != 0) {
            if (botInfoVersion == null) throwNullFieldException("botInfoVersion", flags);
            size += SIZE_INT32;
        }
        if ((flags & 262144) != 0) {
            if (restrictionReason == null) throwNullFieldException("restrictionReason", flags);
            size += computeTLStringSerializedSize(restrictionReason);
        }
        if ((flags & 524288) != 0) {
            if (botInlinePlaceholder == null) throwNullFieldException("botInlinePlaceholder", flags);
            size += computeTLStringSerializedSize(botInlinePlaceholder);
        }
        if ((flags & 4194304) != 0) {
            if (langCode == null) throwNullFieldException("langCode", flags);
            size += computeTLStringSerializedSize(langCode);
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

    public boolean getMin() {
        return min;
    }

    public void setMin(boolean min) {
        this.min = min;
    }

    public boolean getBotInlineGeo() {
        return botInlineGeo;
    }

    public void setBotInlineGeo(boolean botInlineGeo) {
        this.botInlineGeo = botInlineGeo;
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

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
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
