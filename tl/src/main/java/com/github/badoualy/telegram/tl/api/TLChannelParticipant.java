
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;



public class TLChannelParticipant extends TLAbsChannelParticipant {
    public static final int CLASS_ID = 0x15ebac1d;

    public TLChannelParticipant() {

    }


    public TLChannelParticipant(        int _userId,         int _date) {
        this.userId = _userId;
        this.date = _date;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int date;


    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
        writeInt(this.date, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
        this.date = readInt(stream);
    }



    @Override
    public String toString() {
        return "channelParticipant#15ebac1d";
    }

}
