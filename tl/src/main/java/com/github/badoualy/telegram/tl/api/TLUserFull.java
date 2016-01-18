
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLUserFull extends TLObject {

    public static final int CLASS_ID = 0x771095da;

    public TLUserFull() {

    }


    public TLUserFull(        com.github.badoualy.telegram.tl.api.TLAbsUser _user,         com.github.badoualy.telegram.tl.api.contacts.TLLink _link,         com.github.badoualy.telegram.tl.api.TLAbsPhoto _profilePhoto,         com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings _notifySettings,         boolean _blocked,         String _realFirstName,         String _realLastName) {
        this.user = _user;
        this.link = _link;
        this.profilePhoto = _profilePhoto;
        this.notifySettings = _notifySettings;
        this.blocked = _blocked;
        this.realFirstName = _realFirstName;
        this.realLastName = _realLastName;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsUser user;

    protected com.github.badoualy.telegram.tl.api.contacts.TLLink link;

    protected com.github.badoualy.telegram.tl.api.TLAbsPhoto profilePhoto;

    protected com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings notifySettings;

    protected boolean blocked;

    protected String realFirstName;

    protected String realLastName;


    public com.github.badoualy.telegram.tl.api.TLAbsUser getUser() {
        return user;
    }

    public void setUser(com.github.badoualy.telegram.tl.api.TLAbsUser value) {
        this.user = value;
    }

    public com.github.badoualy.telegram.tl.api.contacts.TLLink getLink() {
        return link;
    }

    public void setLink(com.github.badoualy.telegram.tl.api.contacts.TLLink value) {
        this.link = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsPhoto getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(com.github.badoualy.telegram.tl.api.TLAbsPhoto value) {
        this.profilePhoto = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings getNotifySettings() {
        return notifySettings;
    }

    public void setNotifySettings(com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings value) {
        this.notifySettings = value;
    }

    public boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(boolean value) {
        this.blocked = value;
    }

    public String getRealFirstName() {
        return realFirstName;
    }

    public void setRealFirstName(String value) {
        this.realFirstName = value;
    }

    public String getRealLastName() {
        return realLastName;
    }

    public void setRealLastName(String value) {
        this.realLastName = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.user, stream);
        writeTLObject(this.link, stream);
        writeTLObject(this.profilePhoto, stream);
        writeTLObject(this.notifySettings, stream);
        writeTLBool(this.blocked, stream);
        writeTLString(this.realFirstName, stream);
        writeTLString(this.realLastName, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.user = (com.github.badoualy.telegram.tl.api.TLAbsUser)readTLObject(stream, context);
        this.link = (com.github.badoualy.telegram.tl.api.contacts.TLLink)readTLObject(stream, context);
        this.profilePhoto = (com.github.badoualy.telegram.tl.api.TLAbsPhoto)readTLObject(stream, context);
        this.notifySettings = (com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings)readTLObject(stream, context);
        this.blocked = readTLBool(stream);
        this.realFirstName = readTLString(stream);
        this.realLastName = readTLString(stream);
    }


    @Override
    public String toString() {
        return "userFull#771095da";
    }

}
