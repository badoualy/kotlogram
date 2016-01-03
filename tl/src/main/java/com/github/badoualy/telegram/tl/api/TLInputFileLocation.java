
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputFileLocation extends TLAbsInputFileLocation {
    public static final int CLASS_ID = 0x14637196;

    public TLInputFileLocation() {

    }


    public TLInputFileLocation(        long _volumeId,         int _localId,         long _secret) {
        this.volumeId = _volumeId;
        this.localId = _localId;
        this.secret = _secret;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected long volumeId;

    protected int localId;

    protected long secret;


    public long getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(long value) {
        this.volumeId = value;
    }

    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int value) {
        this.localId = value;
    }

    public long getSecret() {
        return secret;
    }

    public void setSecret(long value) {
        this.secret = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.volumeId, stream);
        writeInt(this.localId, stream);
        writeLong(this.secret, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.volumeId = readLong(stream);
        this.localId = readInt(stream);
        this.secret = readLong(stream);
    }



    @Override
    public String toString() {
        return "inputFileLocation#14637196";
    }

}
