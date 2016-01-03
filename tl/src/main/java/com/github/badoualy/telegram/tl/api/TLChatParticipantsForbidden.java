
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



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
