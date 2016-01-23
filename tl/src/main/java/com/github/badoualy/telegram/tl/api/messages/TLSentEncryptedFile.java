package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsEncryptedFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLSentEncryptedFile extends TLAbsSentEncryptedMessage {
    public static final int CLASS_ID = 0x9493ff32;

    protected TLAbsEncryptedFile file;

    public TLSentEncryptedFile() {
    }

    public TLSentEncryptedFile(int date, TLAbsEncryptedFile file) {
        this.date = date;
        this.file = file;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(date, stream);
        writeTLObject(file, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        date = readInt(stream);
        file = (com.github.badoualy.telegram.tl.api.TLAbsEncryptedFile) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "messages.sentEncryptedFile#9493ff32";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TLAbsEncryptedFile getFile() {
        return file;
    }

    public void setFile(TLAbsEncryptedFile file) {
        this.file = file;
    }
}
