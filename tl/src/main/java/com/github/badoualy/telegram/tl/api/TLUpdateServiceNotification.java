package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeBoolean;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateServiceNotification extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x382dd3e4;

    protected String type;

    protected String message;

    protected TLAbsMessageMedia media;

    protected boolean popup;

    private final String _constructor = "updateServiceNotification#382dd3e4";

    public TLUpdateServiceNotification() {
    }

    public TLUpdateServiceNotification(String type, String message, TLAbsMessageMedia media, boolean popup) {
        this.type = type;
        this.message = message;
        this.media = media;
        this.popup = popup;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(type, stream);
        writeString(message, stream);
        writeTLObject(media, stream);
        writeBoolean(popup, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        type = readTLString(stream);
        message = readTLString(stream);
        media = readTLObject(stream, context, TLAbsMessageMedia.class, -1);
        popup = readTLBool(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(type);
        size += computeTLStringSerializedSize(message);
        size += media.computeSerializedSize();
        size += SIZE_BOOLEAN;
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

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLUpdateServiceNotification)) return false;
        if (object == this) return true;

        TLUpdateServiceNotification o = (TLUpdateServiceNotification) object;

        return (type == o.type || (type != null && o.type != null && type.equals(o.type)))
                && (message == o.message || (message != null && o.message != null && message.equals(o.message)))
                && (media == o.media || (media != null && o.media != null && media.equals(o.media)))
                && popup == o.popup;
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

    public boolean getPopup() {
        return popup;
    }

    public void setPopup(boolean popup) {
        this.popup = popup;
    }
}
