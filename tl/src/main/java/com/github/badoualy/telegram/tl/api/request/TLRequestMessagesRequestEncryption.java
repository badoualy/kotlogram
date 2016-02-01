package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesRequestEncryption extends TLMethod<TLAbsEncryptedChat> {
    public static final int CONSTRUCTOR_ID = 0xf64daf43;

    protected TLAbsInputUser userId;

    protected int randomId;

    protected TLBytes gA;

    public TLRequestMessagesRequestEncryption() {
    }

    public TLRequestMessagesRequestEncryption(TLAbsInputUser userId, int randomId, TLBytes gA) {
        this.userId = userId;
        this.randomId = randomId;
        this.gA = gA;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsEncryptedChat deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsEncryptedChat)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsEncryptedChat) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(userId, stream);
        writeInt(randomId, stream);
        writeTLBytes(gA, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        userId = (com.github.badoualy.telegram.tl.api.TLAbsInputUser) readTLObject(stream, context);
        randomId = readInt(stream);
        gA = readTLBytes(stream, context);
    }

    @Override
    public String toString() {
        return "messages.requestEncryption#f64daf43";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLAbsInputUser getUserId() {
        return userId;
    }

    public void setUserId(TLAbsInputUser userId) {
        this.userId = userId;
    }

    public int getRandomId() {
        return randomId;
    }

    public void setRandomId(int randomId) {
        this.randomId = randomId;
    }

    public TLBytes getGA() {
        return gA;
    }

    public void setGA(TLBytes gA) {
        this.gA = gA;
    }
}
