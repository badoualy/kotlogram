
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLInputBotInlineMessageText extends TLAbsInputBotInlineMessage {
    public static final int CLASS_ID = 0xadf0df71;

    public TLInputBotInlineMessageText() {

    }


    public TLInputBotInlineMessageText(        int _flags,         boolean _noWebpage,         String _message,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessageEntity> _entities) {
        this.flags = _flags;
        this.noWebpage = _noWebpage;
        this.message = _message;
        this.entities = _entities;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int flags;

    protected boolean noWebpage;

    protected String message;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessageEntity> entities;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public boolean getNoWebpage() {
        return noWebpage;
    }

    public void setNoWebpage(boolean value) {
        this.noWebpage = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessageEntity> value) {
        this.entities = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        flags = noWebpage ? (flags | 1) : (flags &~ 1);
        writeInt(this.flags, stream);
        if ((this.flags & 1) != 0)
            writeTLBool(this.noWebpage, stream);
        writeTLString(this.message, stream);
        if ((this.flags & 2) != 0)
            writeTLVector(this.entities, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.noWebpage = (this.flags & 1) != 0;
        this.message = readTLString(stream);
        if ((this.flags & 2) != 0)
            this.entities = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "inputBotInlineMessageText#adf0df71";
    }

}
