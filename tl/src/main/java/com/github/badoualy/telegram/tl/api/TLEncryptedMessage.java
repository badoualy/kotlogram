package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLEncryptedMessage extends TLAbsEncryptedMessage {

    public static final int CONSTRUCTOR_ID = 0xed18c118;

    protected TLAbsEncryptedFile file;

    private final String _constructor = "encryptedMessage#ed18c118";

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
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        randomId = readLong(stream);
        chatId = readInt(stream);
        date = readInt(stream);
        bytes = readTLBytes(stream, context);
        file = readTLObject(stream, context, TLAbsEncryptedFile.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLBytesSerializedSize(bytes);
        size += file.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
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
