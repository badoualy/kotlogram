package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLBotInlineMediaResultPhoto extends TLAbsBotInlineResult {
    public static final int CLASS_ID = 0xc5528587;

    protected TLAbsPhoto photo;

    public TLBotInlineMediaResultPhoto() {
    }

    public TLBotInlineMediaResultPhoto(String id, String type, TLAbsPhoto photo, TLAbsBotInlineMessage sendMessage) {
        this.id = id;
        this.type = type;
        this.photo = photo;
        this.sendMessage = sendMessage;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(id, stream);
        writeTLString(type, stream);
        writeTLObject(photo, stream);
        writeTLObject(sendMessage, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readTLString(stream);
        type = readTLString(stream);
        photo = (com.github.badoualy.telegram.tl.api.TLAbsPhoto) readTLObject(stream, context);
        sendMessage = (com.github.badoualy.telegram.tl.api.TLAbsBotInlineMessage) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "botInlineMediaResultPhoto#c5528587";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TLAbsPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsPhoto photo) {
        this.photo = photo;
    }

    public TLAbsBotInlineMessage getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(TLAbsBotInlineMessage sendMessage) {
        this.sendMessage = sendMessage;
    }
}
