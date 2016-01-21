
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;


public class TLRequestMessagesToggleChatAdmins extends TLMethod<com.github.badoualy.telegram.tl.api.TLAbsUpdates> {

    public static final int CLASS_ID = 0xec8bd9e1;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesToggleChatAdmins(        int _chatId,         boolean _enabled) {
        this.chatId = _chatId;
        this.enabled = _enabled;

    }



    public com.github.badoualy.telegram.tl.api.TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.TLAbsUpdates) {
            return (com.github.badoualy.telegram.tl.api.TLAbsUpdates)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.TLAbsUpdates, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected int chatId;

    protected boolean enabled;


    public int getChatId() {
        return chatId;
    }

    public void setChatId(int value) {
        this.chatId = value;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean value) {
        this.enabled = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.chatId, stream);
        writeTLBool(this.enabled, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
        this.enabled = readTLBool(stream);
    }



    @Override
    public String toString() {
        return "messages.toggleChatAdmins#ec8bd9e1";
    }

}
