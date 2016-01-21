
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;



public class TLUpdateReadChannelInbox extends TLAbsUpdate {
    public static final int CLASS_ID = 0x4214f37f;

    public TLUpdateReadChannelInbox() {

    }


    public TLUpdateReadChannelInbox(        int _channelId,         int _maxId) {
        this.channelId = _channelId;
        this.maxId = _maxId;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int channelId;

    protected int maxId;


    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int value) {
        this.channelId = value;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int value) {
        this.maxId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.channelId, stream);
        writeInt(this.maxId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.channelId = readInt(stream);
        this.maxId = readInt(stream);
    }



    @Override
    public String toString() {
        return "updateReadChannelInbox#4214f37f";
    }

}
