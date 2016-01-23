package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

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
public class TLUpdateNewEncryptedMessage extends TLAbsUpdate {
    public static final int CLASS_ID = 0x12bcbd9a;

    protected TLAbsEncryptedMessage message;

    protected int qts;

    public TLUpdateNewEncryptedMessage() {
    }

    public TLUpdateNewEncryptedMessage(TLAbsEncryptedMessage message, int qts) {
        this.message = message;
        this.qts = qts;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(message, stream);
        writeInt(qts, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        message = (com.github.badoualy.telegram.tl.api.TLAbsEncryptedMessage) readTLObject(stream, context);
        qts = readInt(stream);
    }

    @Override
    public String toString() {
        return "updateNewEncryptedMessage#12bcbd9a";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsEncryptedMessage getMessage() {
        return message;
    }

    public void setMessage(TLAbsEncryptedMessage message) {
        this.message = message;
    }

    public int getQts() {
        return qts;
    }

    public void setQts(int qts) {
        this.qts = qts;
    }
}
