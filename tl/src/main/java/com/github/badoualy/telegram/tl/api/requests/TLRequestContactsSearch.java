
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestContactsSearch extends TLMethod<com.github.badoualy.telegram.tl.api.contacts.TLFound> {

    public static final int CLASS_ID = 0x11f812d8;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestContactsSearch(        String _q,         int _limit) {
        this.q = _q;
        this.limit = _limit;

    }



    public com.github.badoualy.telegram.tl.api.contacts.TLFound deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.contacts.TLFound) {
            return (com.github.badoualy.telegram.tl.api.contacts.TLFound)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.contacts.TLFound, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected String q;

    protected int limit;


    public String getQ() {
        return q;
    }

    public void setQ(String value) {
        this.q = value;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int value) {
        this.limit = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.q, stream);
        writeInt(this.limit, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.q = readTLString(stream);
        this.limit = readInt(stream);
    }



    @Override
    public String toString() {
        return "contacts.search#11f812d8";
    }

}
