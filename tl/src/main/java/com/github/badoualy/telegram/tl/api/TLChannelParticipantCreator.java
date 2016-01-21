
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;



public class TLChannelParticipantCreator extends TLAbsChannelParticipant {
    public static final int CLASS_ID = 0xe3e2e1f9;

    public TLChannelParticipantCreator() {

    }


    public TLChannelParticipantCreator(        int _userId) {
        this.userId = _userId;

    }


    public int getClassId() {
        return CLASS_ID;
    }




    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
    }



    @Override
    public String toString() {
        return "channelParticipantCreator#e3e2e1f9";
    }

}
