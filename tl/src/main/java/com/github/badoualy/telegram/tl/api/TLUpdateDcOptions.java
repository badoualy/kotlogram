
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLUpdateDcOptions extends TLAbsUpdate {
    public static final int CLASS_ID = 0x8e5e9873;

    public TLUpdateDcOptions() {

    }


    public TLUpdateDcOptions(        com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLDcOption> _dcOptions) {
        this.dcOptions = _dcOptions;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLDcOption> dcOptions;


    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLDcOption> getDcOptions() {
        return dcOptions;
    }

    public void setDcOptions(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLDcOption> value) {
        this.dcOptions = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.dcOptions, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.dcOptions = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "updateDcOptions#8e5e9873";
    }

}
