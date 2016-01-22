package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer;
import com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLRequestAccountGetNotifySettings extends TLMethod<TLAbsPeerNotifySettings> {
    public static final int CLASS_ID = 0x12b3ad31;

    protected TLAbsInputNotifyPeer peer;

    public TLRequestAccountGetNotifySettings() {
    }

    public TLRequestAccountGetNotifySettings(TLAbsInputNotifyPeer peer) {
        this.peer = peer;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsPeerNotifySettings deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsPeerNotifySettings)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsPeerNotifySettings) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peer, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peer = (com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "account.getNotifySettings#12b3ad31";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsInputNotifyPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputNotifyPeer peer) {
        this.peer = peer;
    }
}
