
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;



public class TLInputPeerChannel extends TLAbsInputPeer {
    public static final int CLASS_ID = 0x20adaef8;

    public TLInputPeerChannel() {

    }


    public TLInputPeerChannel(        int _channelId,         long _accessHash) {
        this.channelId = _channelId;
        this.accessHash = _accessHash;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int channelId;

    protected long accessHash;


    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int value) {
        this.channelId = value;
    }

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long value) {
        this.accessHash = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.channelId, stream);
        writeLong(this.accessHash, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.channelId = readInt(stream);
        this.accessHash = readLong(stream);
    }



    @Override
    public String toString() {
        return "inputPeerChannel#20adaef8";
    }

}
