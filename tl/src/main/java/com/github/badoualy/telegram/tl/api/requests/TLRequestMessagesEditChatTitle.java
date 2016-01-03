
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestMessagesEditChatTitle extends TLMethod<com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage> {

    public static final int CLASS_ID = 0xb4bc68b5;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesEditChatTitle(        int _chatId,         String _title) {
        this.chatId = _chatId;
        this.title = _title;

    }



    public com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage) {
            return (com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected int chatId;

    protected String title;


    public int getChatId() {
        return chatId;
    }

    public void setChatId(int value) {
        this.chatId = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.chatId, stream);
        writeTLString(this.title, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
        this.title = readTLString(stream);
    }



    @Override
    public String toString() {
        return "messages.editChatTitle#b4bc68b5";
    }

}
