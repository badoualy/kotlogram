
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLBotInlineMediaResultDocument extends TLAbsBotInlineResult {
    public static final int CLASS_ID = 0xf897d33e;

    public TLBotInlineMediaResultDocument() {

    }


    public TLBotInlineMediaResultDocument(        String _id,         String _type,         com.github.badoualy.telegram.tl.api.TLAbsDocument _document,         com.github.badoualy.telegram.tl.api.TLAbsBotInlineMessage _sendMessage) {
        this.id = _id;
        this.type = _type;
        this.document = _document;
        this.sendMessage = _sendMessage;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsDocument document;


    public com.github.badoualy.telegram.tl.api.TLAbsDocument getDocument() {
        return document;
    }

    public void setDocument(com.github.badoualy.telegram.tl.api.TLAbsDocument value) {
        this.document = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.id, stream);
        writeTLString(this.type, stream);
        writeTLObject(this.document, stream);
        writeTLObject(this.sendMessage, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readTLString(stream);
        this.type = readTLString(stream);
        this.document = (com.github.badoualy.telegram.tl.api.TLAbsDocument)readTLObject(stream, context);
        this.sendMessage = (com.github.badoualy.telegram.tl.api.TLAbsBotInlineMessage)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "botInlineMediaResultDocument#f897d33e";
    }

}
