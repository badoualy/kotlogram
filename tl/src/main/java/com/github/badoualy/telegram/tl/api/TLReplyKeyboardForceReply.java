
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;



public class TLReplyKeyboardForceReply extends TLAbsReplyMarkup {
    public static final int CLASS_ID = 0xf4108aa0;

    public TLReplyKeyboardForceReply() {

    }


    public TLReplyKeyboardForceReply(        int _flags,         boolean _singleUse,         boolean _selective) {
        this.flags = _flags;
        this.singleUse = _singleUse;
        this.selective = _selective;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected boolean singleUse;


    public boolean getSingleUse() {
        return singleUse;
    }

    public void setSingleUse(boolean value) {
        this.singleUse = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        flags = singleUse ? (flags | 2) : (flags &~ 2);
        flags = selective ? (flags | 4) : (flags &~ 4);
        writeInt(this.flags, stream);
        if ((this.flags & 2) != 0)
            writeTLBool(this.singleUse, stream);
        if ((this.flags & 4) != 0)
            writeTLBool(this.selective, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.singleUse = (this.flags & 2) != 0;
        this.selective = (this.flags & 4) != 0;
    }



    @Override
    public String toString() {
        return "replyKeyboardForceReply#f4108aa0";
    }

}
