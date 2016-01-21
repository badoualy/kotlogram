
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLMessageActionChannelCreate extends TLAbsMessageAction {
    public static final int CLASS_ID = 0x95d2ac92;

    public TLMessageActionChannelCreate() {

    }


    public TLMessageActionChannelCreate(        String _title) {
        this.title = _title;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.title, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.title = readTLString(stream);
    }



    @Override
    public String toString() {
        return "messageActionChannelCreate#95d2ac92";
    }

}
