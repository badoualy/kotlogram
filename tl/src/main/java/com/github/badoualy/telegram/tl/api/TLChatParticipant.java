
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLChatParticipant extends TLObject {

    public static final int CLASS_ID = 0xc8d7493e;

    public TLChatParticipant() {

    }


    public TLChatParticipant(        int _userId,         int _inviterId,         int _date) {
        this.userId = _userId;
        this.inviterId = _inviterId;
        this.date = _date;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;

    protected int inviterId;

    protected int date;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public int getInviterId() {
        return inviterId;
    }

    public void setInviterId(int value) {
        this.inviterId = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
        writeInt(this.inviterId, stream);
        writeInt(this.date, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
        this.inviterId = readInt(stream);
        this.date = readInt(stream);
    }


    @Override
    public String toString() {
        return "chatParticipant#c8d7493e";
    }

}
