
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestContactsGetSuggested extends TLMethod<com.github.badoualy.telegram.tl.api.contacts.TLSuggested> {

    public static final int CLASS_ID = 0xcd773428;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestContactsGetSuggested(        int _limit) {
        this.limit = _limit;

    }



    public com.github.badoualy.telegram.tl.api.contacts.TLSuggested deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.contacts.TLSuggested) {
            return (com.github.badoualy.telegram.tl.api.contacts.TLSuggested)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.contacts.TLSuggested, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected int limit;


    public int getLimit() {
        return limit;
    }

    public void setLimit(int value) {
        this.limit = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.limit, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.limit = readInt(stream);
    }



    @Override
    public String toString() {
        return "contacts.getSuggested#cd773428";
    }

}
