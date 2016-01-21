
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLChatFull extends TLAbsChatFull {
    public static final int CLASS_ID = 0x2e02a614;

    public TLChatFull() {

    }


    public TLChatFull(        int _id,         com.github.badoualy.telegram.tl.api.TLAbsChatParticipants _participants,         com.github.badoualy.telegram.tl.api.TLAbsPhoto _chatPhoto,         com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings _notifySettings,         com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite _exportedInvite,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsBotInfo> _botInfo) {
        this.id = _id;
        this.participants = _participants;
        this.chatPhoto = _chatPhoto;
        this.notifySettings = _notifySettings;
        this.exportedInvite = _exportedInvite;
        this.botInfo = _botInfo;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsChatParticipants participants;


    public com.github.badoualy.telegram.tl.api.TLAbsChatParticipants getParticipants() {
        return participants;
    }

    public void setParticipants(com.github.badoualy.telegram.tl.api.TLAbsChatParticipants value) {
        this.participants = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeTLObject(this.participants, stream);
        writeTLObject(this.chatPhoto, stream);
        writeTLObject(this.notifySettings, stream);
        writeTLObject(this.exportedInvite, stream);
        writeTLVector(this.botInfo, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.participants = (com.github.badoualy.telegram.tl.api.TLAbsChatParticipants)readTLObject(stream, context);
        this.chatPhoto = (com.github.badoualy.telegram.tl.api.TLAbsPhoto)readTLObject(stream, context);
        this.notifySettings = (com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings)readTLObject(stream, context);
        this.exportedInvite = (com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite)readTLObject(stream, context);
        this.botInfo = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "chatFull#2e02a614";
    }

}
