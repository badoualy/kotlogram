
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestContactsGetStatuses extends TLMethod<com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLContactStatus>> {

    public static final int CLASS_ID = 0xc4a353ee;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestContactsGetStatuses() {

    }



    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLContactStatus> deserializeResponse(InputStream stream, TLContext context) throws IOException {

        return readTLVector(stream, context);

    }
        







    @Override
    public String toString() {
        return "contacts.getStatuses#c4a353ee";
    }

}
