package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateEncryption extends TLAbsUpdate {
    public static final int CLASS_ID = 0xb4a2e88d;

    protected TLAbsEncryptedChat chat;

    protected int date;

    public TLUpdateEncryption() {
    }

    public TLUpdateEncryption(TLAbsEncryptedChat chat, int date) {
        this.chat = chat;
        this.date = date;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(chat, stream);
        writeInt(date, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        chat = (com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat) readTLObject(stream, context);
        date = readInt(stream);
    }

    @Override
    public String toString() {
        return "updateEncryption#b4a2e88d";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsEncryptedChat getChat() {
        return chat;
    }

    public void setChat(TLAbsEncryptedChat chat) {
        this.chat = chat;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
