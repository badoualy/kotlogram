
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;


public class TLRequestAccountGetPassword extends TLMethod<com.github.badoualy.telegram.tl.api.account.TLAbsPassword> {

    public static final int CLASS_ID = 0x548a30f5;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAccountGetPassword() {

    }



    public com.github.badoualy.telegram.tl.api.account.TLAbsPassword deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.account.TLAbsPassword) {
            return (com.github.badoualy.telegram.tl.api.account.TLAbsPassword)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.account.TLAbsPassword, got: " + res.getClass().getCanonicalName());
        }

    }
        







    @Override
    public String toString() {
        return "account.getPassword#548a30f5";
    }

}
