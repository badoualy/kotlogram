
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;


public class TLChatFull extends TLObject {

    public static final int CLASS_ID = 0x630e61be;

    public TLChatFull() {

    }


    public TLChatFull(        int _id,         com.github.badoualy.telegram.tl.api.TLAbsChatParticipants _participants,         com.github.badoualy.telegram.tl.api.TLAbsPhoto _chatPhoto,         com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings _notifySettings) {
        this.id = _id;
        this.participants = _participants;
        this.chatPhoto = _chatPhoto;
        this.notifySettings = _notifySettings;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int id;

    protected com.github.badoualy.telegram.tl.api.TLAbsChatParticipants participants;

    protected com.github.badoualy.telegram.tl.api.TLAbsPhoto chatPhoto;

    protected com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings notifySettings;


    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsChatParticipants getParticipants() {
        return participants;
    }

    public void setParticipants(com.github.badoualy.telegram.tl.api.TLAbsChatParticipants value) {
        this.participants = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsPhoto getChatPhoto() {
        return chatPhoto;
    }

    public void setChatPhoto(com.github.badoualy.telegram.tl.api.TLAbsPhoto value) {
        this.chatPhoto = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings getNotifySettings() {
        return notifySettings;
    }

    public void setNotifySettings(com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings value) {
        this.notifySettings = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeTLObject(this.participants, stream);
        writeTLObject(this.chatPhoto, stream);
        writeTLObject(this.notifySettings, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.participants = (com.github.badoualy.telegram.tl.api.TLAbsChatParticipants)readTLObject(stream, context);
        this.chatPhoto = (com.github.badoualy.telegram.tl.api.TLAbsPhoto)readTLObject(stream, context);
        this.notifySettings = (com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings)readTLObject(stream, context);
    }


    @Override
    public String toString() {
        return "chatFull#630e61be";
    }

}
