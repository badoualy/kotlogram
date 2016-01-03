
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLChatParticipants extends TLAbsChatParticipants {
    public static final int CLASS_ID = 0x7841b415;

    public TLChatParticipants() {

    }


    public TLChatParticipants(        int _chatId,         int _adminId,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLChatParticipant> _participants,         int _version) {
        this.chatId = _chatId;
        this.adminId = _adminId;
        this.participants = _participants;
        this.version = _version;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int adminId;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLChatParticipant> participants;

    protected int version;


    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int value) {
        this.adminId = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLChatParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLChatParticipant> value) {
        this.participants = value;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int value) {
        this.version = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.chatId, stream);
        writeInt(this.adminId, stream);
        writeTLVector(this.participants, stream);
        writeInt(this.version, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
        this.adminId = readInt(stream);
        this.participants = readTLVector(stream, context);
        this.version = readInt(stream);
    }



    @Override
    public String toString() {
        return "chatParticipants#7841b415";
    }

}
