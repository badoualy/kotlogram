
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;


public class TLRequestAccountReportPeer extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0xae189d5f;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAccountReportPeer(        com.github.badoualy.telegram.tl.api.TLAbsInputPeer _peer,         com.github.badoualy.telegram.tl.api.TLAbsReportReason _reason) {
        this.peer = _peer;
        this.reason = _reason;

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
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer;

    protected com.github.badoualy.telegram.tl.api.TLAbsReportReason reason;


    public com.github.badoualy.telegram.tl.api.TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(com.github.badoualy.telegram.tl.api.TLAbsInputPeer value) {
        this.peer = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsReportReason getReason() {
        return reason;
    }

    public void setReason(com.github.badoualy.telegram.tl.api.TLAbsReportReason value) {
        this.reason = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeTLObject(this.reason, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer)readTLObject(stream, context);
        this.reason = (com.github.badoualy.telegram.tl.api.TLAbsReportReason)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "account.reportPeer#ae189d5f";
    }

}
