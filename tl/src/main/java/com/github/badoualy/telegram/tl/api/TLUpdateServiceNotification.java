package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateServiceNotification extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0xebe46819;

    protected int flags;

    protected boolean popup;

    protected Integer inboxDate;

    protected String type;

    protected String message;

    protected TLAbsMessageMedia media;

    protected TLVector<TLAbsMessageEntity> entities;

    private final String _constructor = "updateServiceNotification#ebe46819";

    public TLUpdateServiceNotification() {
    }

    public TLUpdateServiceNotification(boolean popup, Integer inboxDate, String type, String message, TLAbsMessageMedia media, TLVector<TLAbsMessageEntity> entities) {
        this.popup = popup;
        this.inboxDate = inboxDate;
        this.type = type;
        this.message = message;
        this.media = media;
        this.entities = entities;
    }

    private void computeFlags() {
        flags = 0;
        flags = popup ? (flags | 1) : (flags & ~1);
        flags = inboxDate != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 2) != 0) {
            if (inboxDate == null) throwNullFieldException("inboxDate", flags);
            writeInt(inboxDate, stream);
        }
        writeString(type, stream);
        writeString(message, stream);
        writeTLObject(media, stream);
        writeTLVector(entities, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        popup = (flags & 1) != 0;
        inboxDate = (flags & 2) != 0 ? readInt(stream) : null;
        type = readTLString(stream);
        message = readTLString(stream);
        media = readTLObject(stream, context, TLAbsMessageMedia.class, -1);
        entities = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 2) != 0) {
            if (inboxDate == null) throwNullFieldException("inboxDate", flags);
            size += SIZE_INT32;
        }
        size += computeTLStringSerializedSize(type);
        size += computeTLStringSerializedSize(message);
        size += media.computeSerializedSize();
        size += entities.computeSerializedSize();
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

    public boolean getPopup() {
        return popup;
    }

    public void setPopup(boolean popup) {
        this.popup = popup;
    }

    public Integer getInboxDate() {
        return inboxDate;
    }

    public void setInboxDate(Integer inboxDate) {
        this.inboxDate = inboxDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TLAbsMessageMedia getMedia() {
        return media;
    }

    public void setMedia(TLAbsMessageMedia media) {
        this.media = media;
    }

    public TLVector<TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(TLVector<TLAbsMessageEntity> entities) {
        this.entities = entities;
    }
}
