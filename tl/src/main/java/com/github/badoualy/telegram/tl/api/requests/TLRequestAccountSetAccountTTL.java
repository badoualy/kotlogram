
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;


public class TLRequestAccountSetAccountTTL extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0x2442485e;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAccountSetAccountTTL(        com.github.badoualy.telegram.tl.api.TLAccountDaysTTL _ttl) {
        this.ttl = _ttl;

    }



    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof TLBool) {
            return (TLBool)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected TLBool, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLAccountDaysTTL ttl;


    public com.github.badoualy.telegram.tl.api.TLAccountDaysTTL getTtl() {
        return ttl;
    }

    public void setTtl(com.github.badoualy.telegram.tl.api.TLAccountDaysTTL value) {
        this.ttl = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.ttl, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.ttl = (com.github.badoualy.telegram.tl.api.TLAccountDaysTTL)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "account.setAccountTTL#2442485e";
    }

}
