
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;


public class TLRequestAccountUpdatePasswordSettings extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0xfa7c4b86;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAccountUpdatePasswordSettings(        TLBytes _currentPasswordHash,         com.github.badoualy.telegram.tl.api.account.TLPasswordInputSettings _newSettings) {
        this.currentPasswordHash = _currentPasswordHash;
        this.newSettings = _newSettings;

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
        


    protected TLBytes currentPasswordHash;

    protected com.github.badoualy.telegram.tl.api.account.TLPasswordInputSettings newSettings;


    public TLBytes getCurrentPasswordHash() {
        return currentPasswordHash;
    }

    public void setCurrentPasswordHash(TLBytes value) {
        this.currentPasswordHash = value;
    }

    public com.github.badoualy.telegram.tl.api.account.TLPasswordInputSettings getNewSettings() {
        return newSettings;
    }

    public void setNewSettings(com.github.badoualy.telegram.tl.api.account.TLPasswordInputSettings value) {
        this.newSettings = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLBytes(this.currentPasswordHash, stream);
        writeTLObject(this.newSettings, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.currentPasswordHash = readTLBytes(stream, context);
        this.newSettings = (com.github.badoualy.telegram.tl.api.account.TLPasswordInputSettings)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "account.updatePasswordSettings#fa7c4b86";
    }

}
