
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;



public class TLChannelParticipantKicked extends TLAbsChannelParticipant {
    public static final int CLASS_ID = 0x8cc5e69a;

    public TLChannelParticipantKicked() {

    }


    public TLChannelParticipantKicked(        int _userId,         int _kickedBy,         int _date) {
        this.userId = _userId;
        this.kickedBy = _kickedBy;
        this.date = _date;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int kickedBy;

    protected int date;


    public int getKickedBy() {
        return kickedBy;
    }

    public void setKickedBy(int value) {
        this.kickedBy = value;
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
        writeInt(this.kickedBy, stream);
        writeInt(this.date, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
        this.kickedBy = readInt(stream);
        this.date = readInt(stream);
    }



    @Override
    public String toString() {
        return "channelParticipantKicked#8cc5e69a";
    }

}
