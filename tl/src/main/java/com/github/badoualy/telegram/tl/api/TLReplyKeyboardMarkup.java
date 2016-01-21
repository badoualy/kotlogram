
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLReplyKeyboardMarkup extends TLAbsReplyMarkup {
    public static final int CLASS_ID = 0x3502758c;

    public TLReplyKeyboardMarkup() {

    }


    public TLReplyKeyboardMarkup(        int _flags,         boolean _resize,         boolean _singleUse,         boolean _selective,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLKeyboardButtonRow> _rows) {
        this.flags = _flags;
        this.resize = _resize;
        this.singleUse = _singleUse;
        this.selective = _selective;
        this.rows = _rows;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected boolean resize;

    protected boolean singleUse;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLKeyboardButtonRow> rows;


    public boolean getResize() {
        return resize;
    }

    public void setResize(boolean value) {
        this.resize = value;
    }

    public boolean getSingleUse() {
        return singleUse;
    }

    public void setSingleUse(boolean value) {
        this.singleUse = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLKeyboardButtonRow> getRows() {
        return rows;
    }

    public void setRows(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLKeyboardButtonRow> value) {
        this.rows = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        flags = resize ? (flags | 1) : (flags &~ 1);
        flags = singleUse ? (flags | 2) : (flags &~ 2);
        flags = selective ? (flags | 4) : (flags &~ 4);
        writeInt(this.flags, stream);
        if ((this.flags & 1) != 0)
            writeTLBool(this.resize, stream);
        if ((this.flags & 2) != 0)
            writeTLBool(this.singleUse, stream);
        if ((this.flags & 4) != 0)
            writeTLBool(this.selective, stream);
        writeTLVector(this.rows, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.resize = (this.flags & 1) != 0;
        this.singleUse = (this.flags & 2) != 0;
        this.selective = (this.flags & 4) != 0;
        this.rows = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "replyKeyboardMarkup#3502758c";
    }

}
