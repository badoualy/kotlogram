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
        user = (com.github.badoualy.telegram.tl.api.TLAbsUser) readTLObject(stream, context);
        link = (com.github.badoualy.telegram.tl.api.contacts.TLLink) readTLObject(stream, context);
        profilePhoto = (com.github.badoualy.telegram.tl.api.TLAbsPhoto) readTLObject(stream, context);
        notifySettings = (com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings) readTLObject(stream, context);
        blocked = readTLBool(stream);
        botInfo = (com.github.badoualy.telegram.tl.api.TLAbsBotInfo) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "userFull#5a89ac5b";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
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
