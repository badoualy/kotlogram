
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLChatInviteAlready extends TLAbsChatInvite {
    public static final int CLASS_ID = 0x5a686d7c;

    public TLChatInviteAlready() {

    }


    public TLChatInviteAlready(        com.github.badoualy.telegram.tl.api.TLAbsChat _chat) {
        this.chat = _chat;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsChat chat;


    public com.github.badoualy.telegram.tl.api.TLAbsChat getChat() {
        return chat;
    }

    public void setChat(com.github.badoualy.telegram.tl.api.TLAbsChat value) {
        this.chat = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.chat, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chat = (com.github.badoualy.telegram.tl.api.TLAbsChat)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "chatInviteAlready#5a686d7c";
    }

}
