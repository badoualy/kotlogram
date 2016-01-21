
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLBotInlineMediaResultPhoto extends TLAbsBotInlineResult {
    public static final int CLASS_ID = 0xc5528587;

    public TLBotInlineMediaResultPhoto() {

    }


    public TLBotInlineMediaResultPhoto(        String _id,         String _type,         com.github.badoualy.telegram.tl.api.TLAbsPhoto _photo,         com.github.badoualy.telegram.tl.api.TLAbsBotInlineMessage _sendMessage) {
        this.id = _id;
        this.type = _type;
        this.photo = _photo;
        this.sendMessage = _sendMessage;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsPhoto photo;


    public com.github.badoualy.telegram.tl.api.TLAbsPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(com.github.badoualy.telegram.tl.api.TLAbsPhoto value) {
        this.photo = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.id, stream);
        writeTLString(this.type, stream);
        writeTLObject(this.photo, stream);
        writeTLObject(this.sendMessage, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readTLString(stream);
        this.type = readTLString(stream);
        this.photo = (com.github.badoualy.telegram.tl.api.TLAbsPhoto)readTLObject(stream, context);
        this.sendMessage = (com.github.badoualy.telegram.tl.api.TLAbsBotInlineMessage)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "botInlineMediaResultPhoto#c5528587";
    }

}
