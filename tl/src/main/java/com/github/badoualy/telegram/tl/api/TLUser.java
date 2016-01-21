
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



public class TLUser extends TLAbsUser {
    public static final int CLASS_ID = 0xd10d979a;

    public TLUser() {

    }


    public TLUser(        int _flags,         boolean _self,         boolean _contact,         boolean _mutualContact,         boolean _deleted,         boolean _bot,         boolean _botChatHistory,         boolean _botNochats,         boolean _verified,         boolean _restricted,         int _id,         long _accessHash,         String _firstName,         String _lastName,         String _username,         String _phone,         com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto _photo,         com.github.badoualy.telegram.tl.api.TLAbsUserStatus _status,         int _botInfoVersion,         String _restrictionReason,         String _botInlinePlaceholder) {
        this.flags = _flags;
        this.self = _self;
        this.contact = _contact;
        this.mutualContact = _mutualContact;
        this.deleted = _deleted;
        this.bot = _bot;
        this.botChatHistory = _botChatHistory;
        this.botNochats = _botNochats;
        this.verified = _verified;
        this.restricted = _restricted;
        this.id = _id;
        this.accessHash = _accessHash;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.username = _username;
        this.phone = _phone;
        this.photo = _photo;
        this.status = _status;
        this.botInfoVersion = _botInfoVersion;
        this.restrictionReason = _restrictionReason;
        this.botInlinePlaceholder = _botInlinePlaceholder;

    }


    public int getClassId() {
        return CLASS_ID;
    }


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

    protected com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto photo;

    protected com.github.badoualy.telegram.tl.api.TLAbsUserStatus status;

    protected int botInfoVersion;

    protected String restrictionReason;

    protected String botInlinePlaceholder;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public boolean getSelf() {
        return self;
    }

    public void setSelf(boolean value) {
        this.self = value;
    }

    public boolean getContact() {
        return contact;
    }

    public void setContact(boolean value) {
        this.contact = value;
    }

    public boolean getMutualContact() {
        return mutualContact;
    }

    public void setMutualContact(boolean value) {
        this.mutualContact = value;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean value) {
        this.deleted = value;
    }

    public boolean getBot() {
        return bot;
    }

    public void setBot(boolean value) {
        this.bot = value;
    }

    public boolean getBotChatHistory() {
        return botChatHistory;
    }

    public void setBotChatHistory(boolean value) {
        this.botChatHistory = value;
    }

    public boolean getBotNochats() {
        return botNochats;
    }

    public void setBotNochats(boolean value) {
        this.botNochats = value;
    }

    public boolean getVerified() {
        return verified;
    }

    public void setVerified(boolean value) {
        this.verified = value;
    }

    public boolean getRestricted() {
        return restricted;
    }

    public void setRestricted(boolean value) {
        this.restricted = value;
    }

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long value) {
        this.accessHash = value;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        this.lastName = value;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String value) {
        this.username = value;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String value) {
        this.phone = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto getPhoto() {
        return photo;
    }

    public void setPhoto(com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto value) {
        this.photo = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsUserStatus getStatus() {
        return status;
    }

    public void setStatus(com.github.badoualy.telegram.tl.api.TLAbsUserStatus value) {
        this.status = value;
    }

    public int getBotInfoVersion() {
        return botInfoVersion;
    }

    public void setBotInfoVersion(int value) {
        this.botInfoVersion = value;
    }

    public String getRestrictionReason() {
        return restrictionReason;
    }

    public void setRestrictionReason(String value) {
        this.restrictionReason = value;
    }

    public String getBotInlinePlaceholder() {
        return botInlinePlaceholder;
    }

    public void setBotInlinePlaceholder(String value) {
        this.botInlinePlaceholder = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        flags = self ? (flags | 1024) : (flags &~ 1024);
        flags = contact ? (flags | 2048) : (flags &~ 2048);
        flags = mutualContact ? (flags | 4096) : (flags &~ 4096);
        flags = deleted ? (flags | 8192) : (flags &~ 8192);
        flags = bot ? (flags | 16384) : (flags &~ 16384);
        flags = botChatHistory ? (flags | 32768) : (flags &~ 32768);
        flags = botNochats ? (flags | 65536) : (flags &~ 65536);
        flags = verified ? (flags | 131072) : (flags &~ 131072);
        flags = restricted ? (flags | 262144) : (flags &~ 262144);
        writeInt(this.flags, stream);
        if ((this.flags & 1024) != 0)
            writeTLBool(this.self, stream);
        if ((this.flags & 2048) != 0)
            writeTLBool(this.contact, stream);
        if ((this.flags & 4096) != 0)
            writeTLBool(this.mutualContact, stream);
        if ((this.flags & 8192) != 0)
            writeTLBool(this.deleted, stream);
        if ((this.flags & 16384) != 0)
            writeTLBool(this.bot, stream);
        if ((this.flags & 32768) != 0)
            writeTLBool(this.botChatHistory, stream);
        if ((this.flags & 65536) != 0)
            writeTLBool(this.botNochats, stream);
        if ((this.flags & 131072) != 0)
            writeTLBool(this.verified, stream);
        if ((this.flags & 262144) != 0)
            writeTLBool(this.restricted, stream);
        writeInt(this.id, stream);
        if ((this.flags & 1) != 0)
            writeLong(this.accessHash, stream);
        if ((this.flags & 2) != 0)
            writeTLString(this.firstName, stream);
        if ((this.flags & 4) != 0)
            writeTLString(this.lastName, stream);
        if ((this.flags & 8) != 0)
            writeTLString(this.username, stream);
        if ((this.flags & 16) != 0)
            writeTLString(this.phone, stream);
        if ((this.flags & 32) != 0)
            writeTLObject(this.photo, stream);
        if ((this.flags & 64) != 0)
            writeTLObject(this.status, stream);
        if ((this.flags & 16384) != 0)
            writeInt(this.botInfoVersion, stream);
        if ((this.flags & 262144) != 0)
            writeTLString(this.restrictionReason, stream);
        if ((this.flags & 524288) != 0)
            writeTLString(this.botInlinePlaceholder, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.self = (this.flags & 1024) != 0;
        this.contact = (this.flags & 2048) != 0;
        this.mutualContact = (this.flags & 4096) != 0;
        this.deleted = (this.flags & 8192) != 0;
        this.bot = (this.flags & 16384) != 0;
        this.botChatHistory = (this.flags & 32768) != 0;
        this.botNochats = (this.flags & 65536) != 0;
        this.verified = (this.flags & 131072) != 0;
        this.restricted = (this.flags & 262144) != 0;
        this.id = readInt(stream);
        if ((this.flags & 1) != 0)
            this.accessHash = readLong(stream);
        if ((this.flags & 2) != 0)
            this.firstName = readTLString(stream);
        if ((this.flags & 4) != 0)
            this.lastName = readTLString(stream);
        if ((this.flags & 8) != 0)
            this.username = readTLString(stream);
        if ((this.flags & 16) != 0)
            this.phone = readTLString(stream);
        if ((this.flags & 32) != 0)
            this.photo = (com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto)readTLObject(stream, context);
        if ((this.flags & 64) != 0)
            this.status = (com.github.badoualy.telegram.tl.api.TLAbsUserStatus)readTLObject(stream, context);
        if ((this.flags & 16384) != 0)
            this.botInfoVersion = readInt(stream);
        if ((this.flags & 262144) != 0)
            this.restrictionReason = readTLString(stream);
        if ((this.flags & 524288) != 0)
            this.botInlinePlaceholder = readTLString(stream);
    }



    @Override
    public String toString() {
        return "user#d10d979a";
    }

}
