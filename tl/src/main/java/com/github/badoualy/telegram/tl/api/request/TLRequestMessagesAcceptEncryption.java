package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat;
import com.github.badoualy.telegram.tl.api.TLInputEncryptedChat;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesAcceptEncryption extends TLMethod<TLAbsEncryptedChat> {

    public static final int CONSTRUCTOR_ID = 0x3dbc0415;

    protected TLInputEncryptedChat peer;

    protected TLBytes gB;

    protected long keyFingerprint;

    private final String _constructor = "messages.acceptEncryption#3dbc0415";

    public TLRequestMessagesAcceptEncryption() {
    }

    public TLRequestMessagesAcceptEncryption(TLInputEncryptedChat peer, TLBytes gB, long keyFingerprint) {
        this.peer = peer;
        this.gB = gB;
        this.keyFingerprint = keyFingerprint;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsEncryptedChat deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsEncryptedChat)) {
            throw new IOException(
                    "Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response
                            .getClass().getCanonicalName());
        }
        return (TLAbsEncryptedChat) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peer, stream);
        writeTLBytes(gB, stream);
        writeLong(keyFingerprint, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peer = readTLObject(stream, context, TLInputEncryptedChat.class, TLInputEncryptedChat.CONSTRUCTOR_ID);
        gB = readTLBytes(stream, context);
        keyFingerprint = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += peer.computeSerializedSize();
        size += computeTLBytesSerializedSize(gB);
        size += SIZE_INT64;
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

    public TLInputEncryptedChat getPeer() {
        return peer;
    }

    public void setPeer(TLInputEncryptedChat peer) {
        this.peer = peer;
    }

    public TLBytes getGB() {
        return gB;
    }

    public void setGB(TLBytes gB) {
        this.gB = gB;
    }

    public long getKeyFingerprint() {
        return keyFingerprint;
    }

    public void setKeyFingerprint(long keyFingerprint) {
        this.keyFingerprint = keyFingerprint;
    }
}
