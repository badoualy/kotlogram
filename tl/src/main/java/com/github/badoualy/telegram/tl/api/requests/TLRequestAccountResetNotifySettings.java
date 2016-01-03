
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestAccountResetNotifySettings extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0xdb7e1747;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAccountResetNotifySettings() {

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
        







    @Override
    public String toString() {
        return "account.resetNotifySettings#db7e1747";
    }

}
