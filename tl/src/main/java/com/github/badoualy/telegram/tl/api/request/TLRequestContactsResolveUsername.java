package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.contacts.TLResolvedPeer;
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
public class TLRequestContactsResolveUsername extends TLMethod<TLResolvedPeer> {
    public static final int CLASS_ID = 0xf93ccba3;

    protected String username;

    public TLRequestContactsResolveUsername() {
    }

    public TLRequestContactsResolveUsername(String username) {
        this.username = username;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLResolvedPeer deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLResolvedPeer)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLResolvedPeer) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(username, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        username = readTLString(stream);
    }

    @Override
    public String toString() {
        return "contacts.resolveUsername#f93ccba3";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
