package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.contacts.TLLink;
import com.github.badoualy.telegram.tl.core.TLObject;

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
public class TLUserFull extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x5932fc03;

    protected int flags;

    protected boolean blocked;

    protected TLAbsUser user;

    protected String about;

    protected TLLink link;

    protected TLAbsPhoto profilePhoto;

    protected TLAbsPeerNotifySettings notifySettings;

    protected TLBotInfo botInfo;

    private final String _constructor = "userFull#5932fc03";

    public TLUserFull() {
    }

    public TLUserFull(boolean blocked, TLAbsUser user, String about, TLLink link, TLAbsPhoto profilePhoto, TLAbsPeerNotifySettings notifySettings, TLBotInfo botInfo) {
        this.blocked = blocked;
        this.user = user;
        this.about = about;
        this.link = link;
        this.profilePhoto = profilePhoto;
        this.notifySettings = notifySettings;
        this.botInfo = botInfo;
    }

    private void computeFlags() {
        flags = 0;
        flags = blocked ? (flags | 1) : (flags & ~1);
        flags = about != null ? (flags | 2) : (flags & ~2);
        flags = profilePhoto != null ? (flags | 4) : (flags & ~4);
        flags = botInfo != null ? (flags | 8) : (flags & ~8);
        // Fields below may not be serialized due to flags field value
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(user, stream);
        if ((flags & 2) != 0) {
            if (about == null) throwNullFieldException("about", flags);
            writeString(about, stream);
        }
        writeTLObject(link, stream);
        if ((flags & 4) != 0) {
            if (profilePhoto == null) throwNullFieldException("profilePhoto", flags);
            writeTLObject(profilePhoto, stream);
        }
        writeTLObject(notifySettings, stream);
        if ((flags & 8) != 0) {
            if (botInfo == null) throwNullFieldException("botInfo", flags);
            writeTLObject(botInfo, stream);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        blocked = (flags & 1) != 0;
        user = readTLObject(stream, context, TLAbsUser.class, -1);
        about = (flags & 2) != 0 ? readTLString(stream) : null;
        link = readTLObject(stream, context, TLLink.class, TLLink.CONSTRUCTOR_ID);
        profilePhoto = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsPhoto.class, -1) : null;
        notifySettings = readTLObject(stream, context, TLAbsPeerNotifySettings.class, -1);
        botInfo = (flags & 8) != 0 ? readTLObject(stream, context, TLBotInfo.class, TLBotInfo.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += user.computeSerializedSize();
        if ((flags & 2) != 0) {
            if (about == null) throwNullFieldException("about", flags);
            size += computeTLStringSerializedSize(about);
        }
        size += link.computeSerializedSize();
        if ((flags & 4) != 0) {
            if (profilePhoto == null) throwNullFieldException("profilePhoto", flags);
            size += profilePhoto.computeSerializedSize();
        }
        size += notifySettings.computeSerializedSize();
        if ((flags & 8) != 0) {
            if (botInfo == null) throwNullFieldException("botInfo", flags);
            size += botInfo.computeSerializedSize();
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

    public boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public TLAbsUser getUser() {
        return user;
    }

    public void setUser(TLAbsUser user) {
        this.user = user;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
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

    public TLBotInfo getBotInfo() {
        return botInfo;
    }

    public void setBotInfo(TLBotInfo botInfo) {
        this.botInfo = botInfo;
    }
}
