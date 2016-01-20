
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;


public class TLRequestAccountGetAccountTTL extends TLMethod<com.github.badoualy.telegram.tl.api.TLAccountDaysTTL> {

    public static final int CLASS_ID = 0x8fc711d;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAccountGetAccountTTL() {

    }



    public com.github.badoualy.telegram.tl.api.TLAccountDaysTTL deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.TLAccountDaysTTL) {
            return (com.github.badoualy.telegram.tl.api.TLAccountDaysTTL)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.TLAccountDaysTTL, got: " + res.getClass().getCanonicalName());
        }

    }
        







    @Override
    public String toString() {
        return "account.getAccountTTL#8fc711d";
    }

}
