package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer;
import com.github.badoualy.telegram.tl.api.TLInputPeerNotifySettings;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestAccountUpdateNotifySettings extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0x84be5b93;

    protected TLAbsInputNotifyPeer peer;

    protected TLInputPeerNotifySettings settings;

    public TLRequestAccountUpdateNotifySettings() {
    }

    public TLRequestAccountUpdateNotifySettings(TLAbsInputNotifyPeer peer, TLInputPeerNotifySettings settings) {
        this.peer = peer;
        this.settings = settings;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBool)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLBool) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peer, stream);
        writeTLObject(settings, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peer = (TLAbsInputNotifyPeer) readTLObject(stream, context);
        settings = (TLInputPeerNotifySettings) readTLObject(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += peer.computeSerializedSize();
        size += settings.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "account.updateNotifySettings#84be5b93";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLAbsInputNotifyPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputNotifyPeer peer) {
        this.peer = peer;
    }

    public TLInputPeerNotifySettings getSettings() {
        return settings;
    }

    public void setSettings(TLInputPeerNotifySettings settings) {
        this.settings = settings;
    }
}
