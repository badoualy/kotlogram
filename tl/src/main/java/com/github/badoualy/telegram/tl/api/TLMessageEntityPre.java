
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLMessageEntityPre extends TLAbsMessageEntity {
    public static final int CLASS_ID = 0x73924be0;

    public TLMessageEntityPre() {

    }


    public TLMessageEntityPre(        int _offset,         int _length,         String _language) {
        this.offset = _offset;
        this.length = _length;
        this.language = _language;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String language;


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String value) {
        this.language = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.offset, stream);
        writeInt(this.length, stream);
        writeTLString(this.language, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.offset = readInt(stream);
        this.length = readInt(stream);
        this.language = readTLString(stream);
    }



    @Override
    public String toString() {
        return "messageEntityPre#73924be0";
    }

}
