
package com.github.badoualy.telegram.tl.api.messages;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



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
