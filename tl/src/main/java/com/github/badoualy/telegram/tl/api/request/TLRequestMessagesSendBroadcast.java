package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputMedia;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesSendBroadcast extends TLMethod<TLAbsUpdates> {
    public static final int CLASS_ID = 0xbf73f4da;

    protected TLVector<TLAbsInputUser> contacts;

    protected TLVector<Long> randomId;

    protected String message;

    protected TLAbsInputMedia media;

    public TLRequestMessagesSendBroadcast() {
    }

    public TLRequestMessagesSendBroadcast(TLVector<TLAbsInputUser> contacts, TLVector<Long> randomId, String message, TLAbsInputMedia media) {
        this.contacts = contacts;
        this.randomId = randomId;
        this.message = message;
        this.media = media;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUpdates)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsUpdates) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(contacts, stream);
        writeTLVector(randomId, stream);
        writeTLString(message, stream);
        writeTLObject(media, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        contacts = readTLVector(stream, context);
        randomId = readTLVector(stream, context);
        message = readTLString(stream);
        media = (com.github.badoualy.telegram.tl.api.TLAbsInputMedia) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "messages.sendBroadcast#bf73f4da";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLVector<TLAbsInputUser> getContacts() {
        return contacts;
    }

    public void setContacts(TLVector<TLAbsInputUser> contacts) {
        this.contacts = contacts;
    }

    public TLVector<Long> getRandomId() {
        return randomId;
    }

    public void setRandomId(TLVector<Long> randomId) {
        this.randomId = randomId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TLAbsInputMedia getMedia() {
        return media;
    }

    public void setMedia(TLAbsInputMedia media) {
        this.media = media;
    }
}
