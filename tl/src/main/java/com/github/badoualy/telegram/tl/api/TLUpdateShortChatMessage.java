
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLUpdateShortChatMessage extends TLAbsUpdates {
    public static final int CLASS_ID = 0x2b2fbd4e;

    public TLUpdateShortChatMessage() {

    }


    public TLUpdateShortChatMessage(        int _id,         int _fromId,         int _chatId,         String _message,         int _pts,         int _date,         int _seq) {
        this.id = _id;
        this.fromId = _fromId;
        this.chatId = _chatId;
        this.message = _message;
        this.pts = _pts;
        this.date = _date;
        this.seq = _seq;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int id;

    protected int fromId;

    protected int chatId;

    protected String message;

    protected int pts;

    protected int date;

    protected int seq;


    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int value) {
        this.fromId = value;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int value) {
        this.chatId = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int value) {
        this.pts = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int value) {
        this.seq = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeInt(this.fromId, stream);
        writeInt(this.chatId, stream);
        writeTLString(this.message, stream);
        writeInt(this.pts, stream);
        writeInt(this.date, stream);
        writeInt(this.seq, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.fromId = readInt(stream);
        this.chatId = readInt(stream);
        this.message = readTLString(stream);
        this.pts = readInt(stream);
        this.date = readInt(stream);
        this.seq = readInt(stream);
    }



    @Override
    public String toString() {
        return "updateShortChatMessage#2b2fbd4e";
    }

}
