
package com.github.badoualy.telegram.tl.api.messages;


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



public class TLStatedMessage extends TLAbsStatedMessage {
    public static final int CLASS_ID = 0xd07ae726;

    public TLStatedMessage() {

    }


    public TLStatedMessage(        com.github.badoualy.telegram.tl.api.TLAbsMessage _message,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> _chats,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> _users,         int _pts,         int _seq) {
        this.message = _message;
        this.chats = _chats;
        this.users = _users;
        this.pts = _pts;
        this.seq = _seq;

    }


    public int getClassId() {
        return CLASS_ID;
    }




    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.message, stream);
        writeTLVector(this.chats, stream);
        writeTLVector(this.users, stream);
        writeInt(this.pts, stream);
        writeInt(this.seq, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.message = (com.github.badoualy.telegram.tl.api.TLAbsMessage)readTLObject(stream, context);
        this.chats = readTLVector(stream, context);
        this.users = readTLVector(stream, context);
        this.pts = readInt(stream);
        this.seq = readInt(stream);
    }



    @Override
    public String toString() {
        return "messages.statedMessage#d07ae726";
    }

}
