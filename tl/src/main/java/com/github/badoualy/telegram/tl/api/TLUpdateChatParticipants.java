
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLUpdateChatParticipants extends TLAbsUpdate {
    public static final int CLASS_ID = 0x7761198;

    public TLUpdateChatParticipants() {

    }


    public TLUpdateChatParticipants(        com.github.badoualy.telegram.tl.api.TLAbsChatParticipants _participants) {
        this.participants = _participants;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsChatParticipants participants;


    public com.github.badoualy.telegram.tl.api.TLAbsChatParticipants getParticipants() {
        return participants;
    }

    public void setParticipants(com.github.badoualy.telegram.tl.api.TLAbsChatParticipants value) {
        this.participants = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.participants, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.participants = (com.github.badoualy.telegram.tl.api.TLAbsChatParticipants)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "updateChatParticipants#7761198";
    }

}
