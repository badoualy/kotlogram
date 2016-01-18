
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



public class TLUpdateServiceNotification extends TLAbsUpdate {
    public static final int CLASS_ID = 0x382dd3e4;

    public TLUpdateServiceNotification() {

    }


    public TLUpdateServiceNotification(        String _type,         String _message,         com.github.badoualy.telegram.tl.api.TLAbsMessageMedia _media,         boolean _popup) {
        this.type = _type;
        this.message = _message;
        this.media = _media;
        this.popup = _popup;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String type;

    protected String message;

    protected com.github.badoualy.telegram.tl.api.TLAbsMessageMedia media;

    protected boolean popup;


    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsMessageMedia getMedia() {
        return media;
    }

    public void setMedia(com.github.badoualy.telegram.tl.api.TLAbsMessageMedia value) {
        this.media = value;
    }

    public boolean getPopup() {
        return popup;
    }

    public void setPopup(boolean value) {
        this.popup = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.type, stream);
        writeTLString(this.message, stream);
        writeTLObject(this.media, stream);
        writeTLBool(this.popup, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.type = readTLString(stream);
        this.message = readTLString(stream);
        this.media = (com.github.badoualy.telegram.tl.api.TLAbsMessageMedia)readTLObject(stream, context);
        this.popup = readTLBool(stream);
    }



    @Override
    public String toString() {
        return "updateServiceNotification#382dd3e4";
    }

}
