
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestHelpGetNearestDc extends TLMethod<com.github.badoualy.telegram.tl.api.TLNearestDc> {

    public static final int CLASS_ID = 0x1fb33026;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestHelpGetNearestDc() {

    }



    public com.github.badoualy.telegram.tl.api.TLNearestDc deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.TLNearestDc) {
            return (com.github.badoualy.telegram.tl.api.TLNearestDc)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.TLNearestDc, got: " + res.getClass().getCanonicalName());
        }

    }
        







    @Override
    public String toString() {
        return "help.getNearestDc#1fb33026";
    }

}
