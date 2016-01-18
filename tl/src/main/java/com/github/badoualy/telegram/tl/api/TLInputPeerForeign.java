
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;



public class TLInputPeerForeign extends TLAbsInputPeer {
    public static final int CLASS_ID = 0x9b447325;

    public TLInputPeerForeign() {

    }


    public TLInputPeerForeign(        int _userId,         long _accessHash) {
        this.userId = _userId;
        this.accessHash = _accessHash;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;

    protected long accessHash;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long value) {
        this.accessHash = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
        writeLong(this.accessHash, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
        this.accessHash = readLong(stream);
    }



    @Override
    public String toString() {
        return "inputPeerForeign#9b447325";
    }

}
