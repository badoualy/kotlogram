
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;



public class TLChannelParticipantModerator extends TLAbsChannelParticipant {
    public static final int CLASS_ID = 0x91057fef;

    public TLChannelParticipantModerator() {

    }


    public TLChannelParticipantModerator(        int _userId,         int _inviterId,         int _date) {
        this.userId = _userId;
        this.inviterId = _inviterId;
        this.date = _date;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int inviterId;

    protected int date;


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
        return "channelParticipantModerator#91057fef";
    }

}
