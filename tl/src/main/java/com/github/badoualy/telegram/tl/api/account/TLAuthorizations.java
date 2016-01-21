
package com.github.badoualy.telegram.tl.api.account;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;


public class TLAuthorizations extends TLObject {

    public static final int CLASS_ID = 0x1250abde;

    public TLAuthorizations() {

    }


    public TLAuthorizations(        com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAuthorization> _authorizations) {
        this.authorizations = _authorizations;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAuthorization> authorizations;


    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAuthorization> getAuthorizations() {
        return authorizations;
    }

    public void setAuthorizations(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAuthorization> value) {
        this.authorizations = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.authorizations, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.authorizations = readTLVector(stream, context);
    }


    @Override
    public String toString() {
        return "account.authorizations#1250abde";
    }

}
