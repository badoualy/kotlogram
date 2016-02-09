package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.contacts.TLLink;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeBoolean;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUserFull extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x5a89ac5b;

    protected TLAbsUser user;

    protected TLLink link;

    protected TLAbsPhoto profilePhoto;

    protected TLAbsPeerNotifySettings notifySettings;

    protected boolean blocked;

    protected TLAbsBotInfo botInfo;

    public TLUserFull() {
    }

    public TLUserFull(TLAbsUser user, TLLink link, TLAbsPhoto profilePhoto, TLAbsPeerNotifySettings notifySettings, boolean blocked, TLAbsBotInfo botInfo) {
        this.user = user;
        this.link = link;
        this.profilePhoto = profilePhoto;
        this.notifySettings = notifySettings;
        this.blocked = blocked;
        this.botInfo = botInfo;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(user, stream);
        writeTLObject(link, stream);
        writeTLObject(profilePhoto, stream);
        writeTLObject(notifySettings, stream);
        writeBoolean(blocked, stream);
        writeTLObject(botInfo, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        user = readTLObject(stream, context, TLAbsUser.class, -1);
        link = readTLObject(stream, context, TLLink.class, TLLink.CONSTRUCTOR_ID);
        profilePhoto = readTLObject(stream, context, TLAbsPhoto.class, -1);
        notifySettings = readTLObject(stream, context, TLAbsPeerNotifySettings.class, -1);
        blocked = readTLBool(stream);
        botInfo = readTLObject(stream, context, TLAbsBotInfo.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += user.computeSerializedSize();
        size += link.computeSerializedSize();
        size += profilePhoto.computeSerializedSize();
        size += notifySettings.computeSerializedSize();
        size += SIZE_BOOLEAN;
        size += botInfo.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "userFull#5a89ac5b";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLUserFull)) return false;
        if (object == this) return true;

        TLUserFull o = (TLUserFull) object;

        return (user == o.user || (user != null && o.user != null && user.equals(o.user)))
                && (link == o.link || (link != null && o.link != null && link.equals(o.link)))
                && (profilePhoto == o.profilePhoto || (profilePhoto != null && o.profilePhoto != null && profilePhoto.equals(o.profilePhoto)))
                && (notifySettings == o.notifySettings || (notifySettings != null && o.notifySettings != null && notifySettings.equals(o.notifySettings)))
                && blocked == o.blocked
                && (botInfo == o.botInfo || (botInfo != null && o.botInfo != null && botInfo.equals(o.botInfo)));
    }

    public TLAbsUser getUser() {
        return user;
    }

    public void setUser(TLAbsUser user) {
        this.user = user;
    }

    public TLLink getLink() {
        return link;
    }

    public void setLink(TLLink link) {
        this.link = link;
    }

    public TLAbsPhoto getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(TLAbsPhoto profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public TLAbsPeerNotifySettings getNotifySettings() {
        return notifySettings;
    }

    public void setNotifySettings(TLAbsPeerNotifySettings notifySettings) {
        this.notifySettings = notifySettings;
    }

    public boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public TLAbsBotInfo getBotInfo() {
        return botInfo;
    }

    public void setBotInfo(TLAbsBotInfo botInfo) {
        this.botInfo = botInfo;
    }
}
