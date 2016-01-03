
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



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
