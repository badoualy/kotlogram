
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLChatForbidden extends TLAbsChat {
    public static final int CLASS_ID = 0xfb0ccc41;

    public TLChatForbidden() {

    }


    public TLChatForbidden(        int _id,         String _title,         int _date) {
        this.id = _id;
        this.title = _title;
        this.date = _date;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String title;

    protected int date;


    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeTLString(this.title, stream);
        writeInt(this.date, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.title = readTLString(stream);
        this.date = readInt(stream);
    }



    @Override
    public String toString() {
        return "chatForbidden#fb0ccc41";
    }

}
