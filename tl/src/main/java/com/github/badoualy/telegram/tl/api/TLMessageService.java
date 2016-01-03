
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLMessageService extends TLAbsMessage {
    public static final int CLASS_ID = 0x1d86f70e;

    public TLMessageService() {

    }


    public TLMessageService(        int _flags,         int _id,         int _fromId,         com.github.badoualy.telegram.tl.api.TLAbsPeer _toId,         int _date,         com.github.badoualy.telegram.tl.api.TLAbsMessageAction _action) {
        this.flags = _flags;
        this.id = _id;
        this.fromId = _fromId;
        this.toId = _toId;
        this.date = _date;
        this.action = _action;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int flags;

    protected int fromId;

    protected com.github.badoualy.telegram.tl.api.TLAbsPeer toId;

    protected int date;

    protected com.github.badoualy.telegram.tl.api.TLAbsMessageAction action;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int value) {
        this.fromId = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsPeer getToId() {
        return toId;
    }

    public void setToId(com.github.badoualy.telegram.tl.api.TLAbsPeer value) {
        this.toId = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsMessageAction getAction() {
        return action;
    }

    public void setAction(com.github.badoualy.telegram.tl.api.TLAbsMessageAction value) {
        this.action = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.flags, stream);
        writeInt(this.id, stream);
        writeInt(this.fromId, stream);
        writeTLObject(this.toId, stream);
        writeInt(this.date, stream);
        writeTLObject(this.action, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.id = readInt(stream);
        this.fromId = readInt(stream);
        this.toId = (com.github.badoualy.telegram.tl.api.TLAbsPeer)readTLObject(stream, context);
        this.date = readInt(stream);
        this.action = (com.github.badoualy.telegram.tl.api.TLAbsMessageAction)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "messageService#1d86f70e";
    }

}
