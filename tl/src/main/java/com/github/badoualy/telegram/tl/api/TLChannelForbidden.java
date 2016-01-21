
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLChannelForbidden extends TLAbsChat {
    public static final int CLASS_ID = 0x2d85832c;

    public TLChannelForbidden() {

    }


    public TLChannelForbidden(        int _id,         long _accessHash,         String _title) {
        this.id = _id;
        this.accessHash = _accessHash;
        this.title = _title;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected long accessHash;

    protected String title;


    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long value) {
        this.accessHash = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeLong(this.accessHash, stream);
        writeTLString(this.title, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.accessHash = readLong(stream);
        this.title = readTLString(stream);
    }



    @Override
    public String toString() {
        return "channelForbidden#2d85832c";
    }

}
