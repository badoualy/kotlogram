
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



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
