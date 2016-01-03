
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestAuthExportAuthorization extends TLMethod<com.github.badoualy.telegram.tl.api.auth.TLExportedAuthorization> {

    public static final int CLASS_ID = 0xe5bfffcd;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAuthExportAuthorization(        int _dcId) {
        this.dcId = _dcId;

    }



    public com.github.badoualy.telegram.tl.api.auth.TLExportedAuthorization deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.auth.TLExportedAuthorization) {
            return (com.github.badoualy.telegram.tl.api.auth.TLExportedAuthorization)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.auth.TLExportedAuthorization, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected int dcId;


    public int getDcId() {
        return dcId;
    }

    public void setDcId(int value) {
        this.dcId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.dcId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.dcId = readInt(stream);
    }



    @Override
    public String toString() {
        return "auth.exportAuthorization#e5bfffcd";
    }

}
