
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;


public class TLReceivedNotifyMessage extends TLObject {

    public static final int CLASS_ID = 0xa384b779;

    public TLReceivedNotifyMessage() {

    }


    public TLReceivedNotifyMessage(        int _id,         int _flags) {
        this.id = _id;
        this.flags = _flags;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int id;

    protected int flags;


    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeInt(this.flags, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.flags = readInt(stream);
    }


    @Override
    public String toString() {
        return "receivedNotifyMessage#a384b779";
    }

}
