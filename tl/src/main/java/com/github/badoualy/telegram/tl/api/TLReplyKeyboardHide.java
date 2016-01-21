
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;



public class TLReplyKeyboardHide extends TLAbsReplyMarkup {
    public static final int CLASS_ID = 0xa03e5b85;

    public TLReplyKeyboardHide() {

    }


    public TLReplyKeyboardHide(        int _flags,         boolean _selective) {
        this.flags = _flags;
        this.selective = _selective;

    }


    public int getClassId() {
        return CLASS_ID;
    }




    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        flags = selective ? (flags | 4) : (flags &~ 4);
        writeInt(this.flags, stream);
        if ((this.flags & 4) != 0)
            writeTLBool(this.selective, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.selective = (this.flags & 4) != 0;
    }



    @Override
    public String toString() {
        return "replyKeyboardHide#a03e5b85";
    }

}
