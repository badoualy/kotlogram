
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLMessageForwarded extends TLAbsMessage {
    public static final int CLASS_ID = 0xa367e716;

    public TLMessageForwarded() {

    }


    public TLMessageForwarded(        int _flags,         int _id,         int _fwdFromId,         int _fwdDate,         int _fromId,         com.github.badoualy.telegram.tl.api.TLAbsPeer _toId,         int _date,         String _message,         com.github.badoualy.telegram.tl.api.TLAbsMessageMedia _media) {
        this.flags = _flags;
        this.id = _id;
        this.fwdFromId = _fwdFromId;
        this.fwdDate = _fwdDate;
        this.fromId = _fromId;
        this.toId = _toId;
        this.date = _date;
        this.message = _message;
        this.media = _media;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int flags;

    protected int fwdFromId;

    protected int fwdDate;

    protected int fromId;

    protected com.github.badoualy.telegram.tl.api.TLAbsPeer toId;

    protected int date;

    protected String message;

    protected com.github.badoualy.telegram.tl.api.TLAbsMessageMedia media;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public int getFwdFromId() {
        return fwdFromId;
    }

    public void setFwdFromId(int value) {
        this.fwdFromId = value;
    }

    public int getFwdDate() {
        return fwdDate;
    }

    public void setFwdDate(int value) {
        this.fwdDate = value;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsMessageMedia getMedia() {
        return media;
    }

    public void setMedia(com.github.badoualy.telegram.tl.api.TLAbsMessageMedia value) {
        this.media = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.flags, stream);
        writeInt(this.id, stream);
        writeInt(this.fwdFromId, stream);
        writeInt(this.fwdDate, stream);
        writeInt(this.fromId, stream);
        writeTLObject(this.toId, stream);
        writeInt(this.date, stream);
        writeTLString(this.message, stream);
        writeTLObject(this.media, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.id = readInt(stream);
        this.fwdFromId = readInt(stream);
        this.fwdDate = readInt(stream);
        this.fromId = readInt(stream);
        this.toId = (com.github.badoualy.telegram.tl.api.TLAbsPeer)readTLObject(stream, context);
        this.date = readInt(stream);
        this.message = readTLString(stream);
        this.media = (com.github.badoualy.telegram.tl.api.TLAbsMessageMedia)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "messageForwarded#a367e716";
    }

}
