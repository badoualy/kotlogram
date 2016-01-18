
package com.github.badoualy.telegram.tl.api.messages;


import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;



public class TLDhConfigNotModified extends TLAbsDhConfig {
    public static final int CLASS_ID = 0xc0e24635;

    public TLDhConfigNotModified() {

    }


    public TLDhConfigNotModified(        TLBytes _random) {
        this.random = _random;

    }


    public int getClassId() {
        return CLASS_ID;
    }




    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLBytes(this.random, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.random = readTLBytes(stream, context);
    }



    @Override
    public String toString() {
        return "messages.dhConfigNotModified#c0e24635";
    }

}
