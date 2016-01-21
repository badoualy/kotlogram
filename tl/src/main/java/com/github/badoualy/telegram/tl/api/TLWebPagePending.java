
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;



public class TLWebPagePending extends TLAbsWebPage {
    public static final int CLASS_ID = 0xc586da1c;

    public TLWebPagePending() {

    }


    public TLWebPagePending(        long _id,         int _date) {
        this.id = _id;
        this.date = _date;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int date;


    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.id, stream);
        writeInt(this.date, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readLong(stream);
        this.date = readInt(stream);
    }



    @Override
    public String toString() {
        return "webPagePending#c586da1c";
    }

}
