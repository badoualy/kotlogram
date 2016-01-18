
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;

import java.io.IOException;
import java.io.InputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLIntVector;


public class TLRequestContactsExportCard extends TLMethod<com.github.badoualy.telegram.tl.core.TLIntVector> {

    public static final int CLASS_ID = 0x84e53737;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestContactsExportCard() {

    }



    public com.github.badoualy.telegram.tl.core.TLIntVector deserializeResponse(InputStream stream, TLContext context) throws IOException {

        return readTLIntVector(stream, context);

    }
        







    @Override
    public String toString() {
        return "contacts.exportCard#84e53737";
    }

}
