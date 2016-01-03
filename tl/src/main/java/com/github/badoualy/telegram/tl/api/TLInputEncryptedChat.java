
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLInputEncryptedChat extends TLObject {

    public static final int CLASS_ID = 0xf141b5e1;

    public TLInputEncryptedChat() {

    }


    public TLInputEncryptedChat(        int _chatId,         long _accessHash) {
        this.chatId = _chatId;
        this.accessHash = _accessHash;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int chatId;

    protected long accessHash;


    public int getChatId() {
        return chatId;
    }

    public void setChatId(int value) {
        this.chatId = value;
    }

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long value) {
        this.accessHash = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.chatId, stream);
        writeLong(this.accessHash, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
        this.accessHash = readLong(stream);
    }


    @Override
    public String toString() {
        return "inputEncryptedChat#f141b5e1";
    }

}
