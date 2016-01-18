
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;



public class TLChatParticipantsForbidden extends TLAbsChatParticipants {
    public static final int CLASS_ID = 0xfd2bb8a;

    public TLChatParticipantsForbidden() {

    }


    public TLChatParticipantsForbidden(        int _chatId) {
        this.chatId = _chatId;

    }


    public int getClassId() {
        return CLASS_ID;
    }




    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.chatId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
    }



    @Override
    public String toString() {
        return "chatParticipantsForbidden#fd2bb8a";
    }

}
