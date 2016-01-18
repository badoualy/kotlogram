
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;



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
