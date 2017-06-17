package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLBotInlineMediaResult extends TLAbsBotInlineResult {

    public static final int CONSTRUCTOR_ID = 0x17db940b;

    protected TLAbsPhoto photo;

    protected TLAbsDocument document;

    protected String title;

    protected String description;

    private final String _constructor = "botInlineMediaResult#17db940b";

    public TLBotInlineMediaResult() {
    }

    public TLBotInlineMediaResult(String id, String type, TLAbsPhoto photo, TLAbsDocument document, String title, String description, TLAbsBotInlineMessage sendMessage) {
        this.id = id;
        this.type = type;
        this.photo = photo;
        this.document = document;
        this.title = title;
        this.description = description;
        this.sendMessage = sendMessage;
    }

    private void computeFlags() {
        flags = 0;
        flags = photo != null ? (flags | 1) : (flags & ~1);
        flags = document != null ? (flags | 2) : (flags & ~2);
        flags = title != null ? (flags | 4) : (flags & ~4);
        flags = description != null ? (flags | 8) : (flags & ~8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(id, stream);
        writeString(type, stream);
        if ((flags & 1) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            writeTLObject(photo, stream);
        }
        if ((flags & 2) != 0) {
            if (document == null) throwNullFieldException("document", flags);
            writeTLObject(document, stream);
        }
        if ((flags & 4) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            writeString(title, stream);
        }
        if ((flags & 8) != 0) {
            if (description == null) throwNullFieldException("description", flags);
            writeString(description, stream);
        }
        writeTLObject(sendMessage, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        id = readTLString(stream);
        type = readTLString(stream);
        photo = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsPhoto.class, -1) : null;
        document = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsDocument.class, -1) : null;
        title = (flags & 4) != 0 ? readTLString(stream) : null;
        description = (flags & 8) != 0 ? readTLString(stream) : null;
        sendMessage = readTLObject(stream, context, TLAbsBotInlineMessage.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(id);
        size += computeTLStringSerializedSize(type);
        if ((flags & 1) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            size += photo.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (document == null) throwNullFieldException("document", flags);
            size += document.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            size += computeTLStringSerializedSize(title);
        }
        if ((flags & 8) != 0) {
            if (description == null) throwNullFieldException("description", flags);
            size += computeTLStringSerializedSize(description);
        }
        size += sendMessage.computeSerializedSize();
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

    public TLAbsDocument getDocument() {
        return document;
    }

    public void setDocument(TLAbsDocument document) {
        this.document = document;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TLAbsBotInlineMessage getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(TLAbsBotInlineMessage sendMessage) {
        this.sendMessage = sendMessage;
    }
}
