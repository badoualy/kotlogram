
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLUpdatePrivacy extends TLAbsUpdate {
    public static final int CLASS_ID = 0xee3b272a;

    public TLUpdatePrivacy() {

    }


    public TLUpdatePrivacy(        com.github.badoualy.telegram.tl.api.TLPrivacyKey _key,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsPrivacyRule> _rules) {
        this.key = _key;
        this.rules = _rules;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLPrivacyKey key;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsPrivacyRule> rules;


    public com.github.badoualy.telegram.tl.api.TLPrivacyKey getKey() {
        return key;
    }

    public void setKey(com.github.badoualy.telegram.tl.api.TLPrivacyKey value) {
        this.key = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsPrivacyRule> getRules() {
        return rules;
    }

    public void setRules(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsPrivacyRule> value) {
        this.rules = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.key, stream);
        writeTLVector(this.rules, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.key = (com.github.badoualy.telegram.tl.api.TLPrivacyKey)readTLObject(stream, context);
        this.rules = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "updatePrivacy#ee3b272a";
    }

}
