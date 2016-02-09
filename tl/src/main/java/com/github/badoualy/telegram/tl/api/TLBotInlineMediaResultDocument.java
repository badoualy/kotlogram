package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLBotInlineMediaResultDocument extends TLAbsBotInlineResult {
    public static final int CONSTRUCTOR_ID = 0xf897d33e;

    protected TLAbsDocument document;

    public TLBotInlineMediaResultDocument() {
    }

    public TLBotInlineMediaResultDocument(String id, String type, TLAbsDocument document, TLAbsBotInlineMessage sendMessage) {
        this.id = id;
        this.type = type;
        this.document = document;
        this.sendMessage = sendMessage;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(id, stream);
        writeString(type, stream);
        writeTLObject(document, stream);
        writeTLObject(sendMessage, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readTLString(stream);
        type = readTLString(stream);
        document = readTLObject(stream, context, TLAbsDocument.class, -1);
        sendMessage = readTLObject(stream, context, TLAbsBotInlineMessage.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(id);
        size += computeTLStringSerializedSize(type);
        size += document.computeSerializedSize();
        size += sendMessage.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "botInlineMediaResultDocument#f897d33e";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLBotInlineMediaResultDocument)) return false;
        if (object == this) return true;

        TLBotInlineMediaResultDocument o = (TLBotInlineMediaResultDocument) object;

        return (id == o.id || (id != null && o.id != null && id.equals(o.id)))
                && (type == o.type || (type != null && o.type != null && type.equals(o.type)))
                && (document == o.document || (document != null && o.document != null && document.equals(o.document)))
                && (sendMessage == o.sendMessage || (sendMessage != null && o.sendMessage != null && sendMessage.equals(o.sendMessage)));
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

    public TLAbsDocument getDocument() {
        return document;
    }

    public void setDocument(TLAbsDocument document) {
        this.document = document;
    }

    public TLAbsBotInlineMessage getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(TLAbsBotInlineMessage sendMessage) {
        this.sendMessage = sendMessage;
    }
}
