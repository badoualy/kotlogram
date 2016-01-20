
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;


public class TLRequestAccountSetPrivacy extends TLMethod<com.github.badoualy.telegram.tl.api.account.TLPrivacyRules> {

    public static final int CLASS_ID = 0xc9f81ce8;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAccountSetPrivacy(        com.github.badoualy.telegram.tl.api.TLInputPrivacyKey _key,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputPrivacyRule> _rules) {
        this.key = _key;
        this.rules = _rules;

    }



    public com.github.badoualy.telegram.tl.api.account.TLPrivacyRules deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.account.TLPrivacyRules) {
            return (com.github.badoualy.telegram.tl.api.account.TLPrivacyRules)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.account.TLPrivacyRules, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLInputPrivacyKey key;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputPrivacyRule> rules;


    public com.github.badoualy.telegram.tl.api.TLInputPrivacyKey getKey() {
        return key;
    }

    public void setKey(com.github.badoualy.telegram.tl.api.TLInputPrivacyKey value) {
        this.key = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputPrivacyRule> getRules() {
        return rules;
    }

    public void setRules(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsInputPrivacyRule> value) {
        this.rules = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.key, stream);
        writeTLVector(this.rules, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.key = (com.github.badoualy.telegram.tl.api.TLInputPrivacyKey)readTLObject(stream, context);
        this.rules = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "account.setPrivacy#c9f81ce8";
    }

}
