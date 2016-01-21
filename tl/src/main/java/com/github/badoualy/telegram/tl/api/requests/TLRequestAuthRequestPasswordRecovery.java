
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;


public class TLRequestAuthRequestPasswordRecovery extends TLMethod<com.github.badoualy.telegram.tl.api.auth.TLPasswordRecovery> {

    public static final int CLASS_ID = 0xd897bc66;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAuthRequestPasswordRecovery() {

    }



    public com.github.badoualy.telegram.tl.api.auth.TLPasswordRecovery deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.auth.TLPasswordRecovery) {
            return (com.github.badoualy.telegram.tl.api.auth.TLPasswordRecovery)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.auth.TLPasswordRecovery, got: " + res.getClass().getCanonicalName());
        }

    }
        







    @Override
    public String toString() {
        return "auth.requestPasswordRecovery#d897bc66";
    }

}
