
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLChatParticipantsForbidden extends TLAbsChatParticipants {
    public static final int CLASS_ID = 0xfc900c2b;

    public TLChatParticipantsForbidden() {

    }


    public TLChatParticipantsForbidden(        int _flags,         int _chatId,         com.github.badoualy.telegram.tl.api.TLAbsChatParticipant _selfParticipant) {
        this.flags = _flags;
        this.chatId = _chatId;
        this.selfParticipant = _selfParticipant;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int flags;

    protected com.github.badoualy.telegram.tl.api.TLAbsChatParticipant selfParticipant;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsChatParticipant getSelfParticipant() {
        return selfParticipant;
    }

    public void setSelfParticipant(com.github.badoualy.telegram.tl.api.TLAbsChatParticipant value) {
        this.selfParticipant = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.flags, stream);
        writeInt(this.chatId, stream);
        if ((this.flags & 1) != 0)
            writeTLObject(this.selfParticipant, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.chatId = readInt(stream);
        if ((this.flags & 1) != 0)
            this.selfParticipant = (com.github.badoualy.telegram.tl.api.TLAbsChatParticipant)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "chatParticipantsForbidden#fc900c2b";
    }

}
