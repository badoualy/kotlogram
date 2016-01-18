
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;



public class TLFileLocationUnavailable extends TLAbsFileLocation {
    public static final int CLASS_ID = 0x7c596b46;

    public TLFileLocationUnavailable() {

    }


    public TLFileLocationUnavailable(        long _volumeId,         int _localId,         long _secret) {
        this.volumeId = _volumeId;
        this.localId = _localId;
        this.secret = _secret;

    }


    public int getClassId() {
        return CLASS_ID;
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
        return "fileLocationUnavailable#7c596b46";
    }

}
