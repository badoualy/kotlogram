
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;


public class TLRequestAccountGetAuthorizations extends TLMethod<com.github.badoualy.telegram.tl.api.account.TLAuthorizations> {

    public static final int CLASS_ID = 0xe320c158;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAccountGetAuthorizations() {

    }



    public com.github.badoualy.telegram.tl.api.account.TLAuthorizations deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.account.TLAuthorizations) {
            return (com.github.badoualy.telegram.tl.api.account.TLAuthorizations)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.account.TLAuthorizations, got: " + res.getClass().getCanonicalName());
        }

    }
        







    @Override
    public String toString() {
        return "account.getAuthorizations#e320c158";
    }

}
