package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeBoolean;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputBotInlineMessageText extends TLAbsInputBotInlineMessage {
    public static final int CONSTRUCTOR_ID = 0xadf0df71;

    protected int flags;

    protected boolean noWebpage;

    protected String message;

    protected TLVector<TLAbsMessageEntity> entities;

    public TLInputBotInlineMessageText() {
    }

    public TLInputBotInlineMessageText(boolean noWebpage, String message, TLVector<TLAbsMessageEntity> entities) {
        this.noWebpage = noWebpage;
        this.message = message;
        this.entities = entities;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        flags = 0;
        flags = noWebpage ? (flags | 1) : (flags &~ 1);
        flags = entities != null ? (flags | 2) : (flags &~ 2);

        writeInt(flags, stream);
        if ((flags & 1) != 0) writeBoolean(noWebpage, stream);
        writeString(message, stream);
        if ((flags & 2) != 0) writeTLVector(entities, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        noWebpage = (flags & 1) != 0;
        message = readTLString(stream);
        if ((flags & 2) != 0) entities = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "inputBotInlineMessageText#adf0df71";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public boolean getNoWebpage() {
        return noWebpage;
    }

    public void setNoWebpage(boolean noWebpage) {
        this.noWebpage = noWebpage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TLVector<TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(TLVector<TLAbsMessageEntity> entities) {
        this.entities = entities;
    }
}
