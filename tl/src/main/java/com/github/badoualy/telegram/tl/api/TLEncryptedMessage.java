package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLEncryptedMessage extends TLAbsEncryptedMessage {
    public static final int CLASS_ID = 0xed18c118;

    protected TLAbsEncryptedFile file;

    public TLEncryptedMessage() {
    }

    public TLEncryptedMessage(long randomId, int chatId, int date, TLBytes bytes, TLAbsEncryptedFile file) {
        this.randomId = randomId;
        this.chatId = chatId;
        this.date = date;
        this.bytes = bytes;
        this.file = file;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(randomId, stream);
        writeInt(chatId, stream);
        writeInt(date, stream);
        writeTLBytes(bytes, stream);
        writeTLObject(file, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        randomId = readLong(stream);
        chatId = readInt(stream);
        date = readInt(stream);
        bytes = readTLBytes(stream, context);
        file = (com.github.badoualy.telegram.tl.api.TLAbsEncryptedFile) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "encryptedMessage#ed18c118";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long randomId) {
        this.randomId = randomId;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TLBytes getBytes() {
        return bytes;
    }

    public void setBytes(TLBytes bytes) {
        this.bytes = bytes;
    }

    public TLAbsEncryptedFile getFile() {
        return file;
    }

    public void setFile(TLAbsEncryptedFile file) {
        this.file = file;
    }
}
