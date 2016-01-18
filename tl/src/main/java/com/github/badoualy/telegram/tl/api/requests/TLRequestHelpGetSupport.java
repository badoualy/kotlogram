
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;


public class TLRequestHelpGetSupport extends TLMethod<com.github.badoualy.telegram.tl.api.help.TLSupport> {

    public static final int CLASS_ID = 0x9cdf08cd;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestHelpGetSupport() {

    }



    public com.github.badoualy.telegram.tl.api.help.TLSupport deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.help.TLSupport) {
            return (com.github.badoualy.telegram.tl.api.help.TLSupport)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.help.TLSupport, got: " + res.getClass().getCanonicalName());
        }

    }
        







    @Override
    public String toString() {
        return "help.getSupport#9cdf08cd";
    }

}
