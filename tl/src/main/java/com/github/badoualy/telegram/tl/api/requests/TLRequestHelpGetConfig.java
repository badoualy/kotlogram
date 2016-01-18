
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;


public class TLRequestHelpGetConfig extends TLMethod<com.github.badoualy.telegram.tl.api.TLConfig> {

    public static final int CLASS_ID = 0xc4f9186b;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestHelpGetConfig() {

    }



    public com.github.badoualy.telegram.tl.api.TLConfig deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.TLConfig) {
            return (com.github.badoualy.telegram.tl.api.TLConfig)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.TLConfig, got: " + res.getClass().getCanonicalName());
        }

    }
        







    @Override
    public String toString() {
        return "help.getConfig#c4f9186b";
    }

}
