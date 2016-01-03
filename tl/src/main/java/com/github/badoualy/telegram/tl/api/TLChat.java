
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLChat extends TLAbsChat {
    public static final int CLASS_ID = 0x6e9c9bc7;

    public TLChat() {

    }


    public TLChat(        int _id,         String _title,         com.github.badoualy.telegram.tl.api.TLAbsChatPhoto _photo,         int _participantsCount,         int _date,         boolean _left,         int _version) {
        this.id = _id;
        this.title = _title;
        this.photo = _photo;
        this.participantsCount = _participantsCount;
        this.date = _date;
        this.left = _left;
        this.version = _version;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String title;

    protected com.github.badoualy.telegram.tl.api.TLAbsChatPhoto photo;

    protected int participantsCount;

    protected int date;

    protected boolean left;

    protected int version;


    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsChatPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(com.github.badoualy.telegram.tl.api.TLAbsChatPhoto value) {
        this.photo = value;
    }

    public int getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(int value) {
        this.participantsCount = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public boolean getLeft() {
        return left;
    }

    public void setLeft(boolean value) {
        this.left = value;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int value) {
        this.version = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeTLString(this.title, stream);
        writeTLObject(this.photo, stream);
        writeInt(this.participantsCount, stream);
        writeInt(this.date, stream);
        writeTLBool(this.left, stream);
        writeInt(this.version, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.title = readTLString(stream);
        this.photo = (com.github.badoualy.telegram.tl.api.TLAbsChatPhoto)readTLObject(stream, context);
        this.participantsCount = readInt(stream);
        this.date = readInt(stream);
        this.left = readTLBool(stream);
        this.version = readInt(stream);
    }



    @Override
    public String toString() {
        return "chat#6e9c9bc7";
    }

}
