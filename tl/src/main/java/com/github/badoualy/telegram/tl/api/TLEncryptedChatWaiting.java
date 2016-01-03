
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLEncryptedChatWaiting extends TLAbsEncryptedChat {
    public static final int CLASS_ID = 0x3bf703dc;

    public TLEncryptedChatWaiting() {

    }


    public TLEncryptedChatWaiting(        int _id,         long _accessHash,         int _date,         int _adminId,         int _participantId) {
        this.id = _id;
        this.accessHash = _accessHash;
        this.date = _date;
        this.adminId = _adminId;
        this.participantId = _participantId;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected long accessHash;

    protected int date;

    protected int adminId;

    protected int participantId;


    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long value) {
        this.accessHash = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int value) {
        this.adminId = value;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int value) {
        this.participantId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeLong(this.accessHash, stream);
        writeInt(this.date, stream);
        writeInt(this.adminId, stream);
        writeInt(this.participantId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.accessHash = readLong(stream);
        this.date = readInt(stream);
        this.adminId = readInt(stream);
        this.participantId = readInt(stream);
    }



    @Override
    public String toString() {
        return "encryptedChatWaiting#3bf703dc";
    }

}
