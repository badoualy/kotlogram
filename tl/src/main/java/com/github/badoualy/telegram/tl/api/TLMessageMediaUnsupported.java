
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLMessageMediaUnsupported extends TLAbsMessageMedia {
    public static final int CLASS_ID = 0x29632a36;

    public TLMessageMediaUnsupported() {

    }


    public TLMessageMediaUnsupported(        TLBytes _bytes) {
        this.bytes = _bytes;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected TLBytes bytes;


    public TLBytes getBytes() {
        return bytes;
    }

    public void setBytes(TLBytes value) {
        this.bytes = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLBytes(this.bytes, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.bytes = readTLBytes(stream, context);
    }



    @Override
    public String toString() {
        return "messageMediaUnsupported#29632a36";
    }

}
