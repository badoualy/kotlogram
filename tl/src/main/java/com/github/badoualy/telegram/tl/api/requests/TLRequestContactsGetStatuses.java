
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;

import java.io.IOException;
import java.io.InputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;


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
