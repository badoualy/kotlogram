package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputMedia;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.core.TLLongVector;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLLongVector;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesSendBroadcast extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0xbf73f4da;

    protected TLVector<TLAbsInputUser> contacts;

    protected TLLongVector randomId;

    protected String message;

    protected TLAbsInputMedia media;

    private final String _constructor = "messages.sendBroadcast#bf73f4da";

    public TLRequestMessagesSendBroadcast() {
    }

    public TLRequestMessagesSendBroadcast(TLVector<TLAbsInputUser> contacts, TLLongVector randomId, String message, TLAbsInputMedia media) {
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
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsUpdates) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(contacts, stream);
        writeTLVector(randomId, stream);
        writeString(message, stream);
        writeTLObject(media, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        contacts = readTLVector(stream, context);
        randomId = readTLLongVector(stream, context);
        message = readTLString(stream);
        media = readTLObject(stream, context, TLAbsInputMedia.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += contacts.computeSerializedSize();
        size += randomId.computeSerializedSize();
        size += computeTLStringSerializedSize(message);
        size += media.computeSerializedSize();
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

    public TLVector<TLAbsInputUser> getContacts() {
        return contacts;
    }

    public void setContacts(TLVector<TLAbsInputUser> contacts) {
        this.contacts = contacts;
    }

    public TLLongVector getRandomId() {
        return randomId;
    }

    public void setRandomId(TLLongVector randomId) {
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
