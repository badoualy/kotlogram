package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;

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
        writeTLString(type, stream);
        writeTLString(message, stream);
        writeTLObject(media, stream);
        writeTLBool(popup, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        type = readTLString(stream);
        message = readTLString(stream);
        media = (com.github.badoualy.telegram.tl.api.TLAbsMessageMedia) readTLObject(stream, context);
        popup = readTLBool(stream);
    }

    @Override
    public String toString() {
        return "updateServiceNotification#382dd3e4";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
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
