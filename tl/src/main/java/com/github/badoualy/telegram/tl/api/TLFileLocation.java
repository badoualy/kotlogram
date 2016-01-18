
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;



public class TLFileLocation extends TLAbsFileLocation {
    public static final int CLASS_ID = 0x53d69076;

    public TLFileLocation() {

    }


    public TLFileLocation(        int _dcId,         long _volumeId,         int _localId,         long _secret) {
        this.dcId = _dcId;
        this.volumeId = _volumeId;
        this.localId = _localId;
        this.secret = _secret;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int dcId;


    public int getDcId() {
        return dcId;
    }

    public void setDcId(int value) {
        this.dcId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.dcId, stream);
        writeLong(this.volumeId, stream);
        writeInt(this.localId, stream);
        writeLong(this.secret, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.dcId = readInt(stream);
        this.volumeId = readLong(stream);
        this.localId = readInt(stream);
        this.secret = readLong(stream);
    }



    @Override
    public String toString() {
        return "fileLocation#53d69076";
    }

}
