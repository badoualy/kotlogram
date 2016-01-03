
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestContactsUnblock extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0xe54100bd;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestContactsUnblock(        com.github.badoualy.telegram.tl.api.TLAbsInputUser _id) {
        this.id = _id;

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
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputUser id;


    public com.github.badoualy.telegram.tl.api.TLAbsInputUser getId() {
        return id;
    }

    public void setId(com.github.badoualy.telegram.tl.api.TLAbsInputUser value) {
        this.id = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.id, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = (com.github.badoualy.telegram.tl.api.TLAbsInputUser)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "contacts.unblock#e54100bd";
    }

}
