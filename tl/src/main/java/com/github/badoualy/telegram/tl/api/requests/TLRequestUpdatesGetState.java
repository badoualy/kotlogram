
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestUpdatesGetState extends TLMethod<com.github.badoualy.telegram.tl.api.updates.TLState> {

    public static final int CLASS_ID = 0xedd4882a;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestUpdatesGetState() {

    }



    public com.github.badoualy.telegram.tl.api.updates.TLState deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.updates.TLState) {
            return (com.github.badoualy.telegram.tl.api.updates.TLState)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.updates.TLState, got: " + res.getClass().getCanonicalName());
        }

    }
        







    @Override
    public String toString() {
        return "updates.getState#edd4882a";
    }

}
