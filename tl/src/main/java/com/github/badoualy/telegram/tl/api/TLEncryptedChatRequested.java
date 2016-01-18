
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;



public class TLEncryptedChatRequested extends TLAbsEncryptedChat {
    public static final int CLASS_ID = 0xc878527e;

    public TLEncryptedChatRequested() {

    }


    public TLEncryptedChatRequested(        int _id,         long _accessHash,         int _date,         int _adminId,         int _participantId,         TLBytes _gA) {
        this.id = _id;
        this.accessHash = _accessHash;
        this.date = _date;
        this.adminId = _adminId;
        this.participantId = _participantId;
        this.gA = _gA;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected long accessHash;

    protected int date;

    protected int adminId;

    protected int participantId;

    protected TLBytes gA;


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

    public TLBytes getGA() {
        return gA;
    }

    public void setGA(TLBytes value) {
        this.gA = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeLong(this.accessHash, stream);
        writeInt(this.date, stream);
        writeInt(this.adminId, stream);
        writeInt(this.participantId, stream);
        writeTLBytes(this.gA, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.accessHash = readLong(stream);
        this.date = readInt(stream);
        this.adminId = readInt(stream);
        this.participantId = readInt(stream);
        this.gA = readTLBytes(stream, context);
    }



    @Override
    public String toString() {
        return "encryptedChatRequested#c878527e";
    }

}
