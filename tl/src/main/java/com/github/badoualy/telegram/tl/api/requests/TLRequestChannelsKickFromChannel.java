
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;


public class TLRequestChannelsKickFromChannel extends TLMethod<com.github.badoualy.telegram.tl.api.TLAbsUpdates> {

    public static final int CLASS_ID = 0xa672de14;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestChannelsKickFromChannel(        com.github.badoualy.telegram.tl.api.TLAbsInputChannel _channel,         com.github.badoualy.telegram.tl.api.TLAbsInputUser _userId,         boolean _kicked) {
        this.channel = _channel;
        this.userId = _userId;
        this.kicked = _kicked;

    }



    public com.github.badoualy.telegram.tl.api.TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.TLAbsUpdates) {
            return (com.github.badoualy.telegram.tl.api.TLAbsUpdates)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.TLAbsUpdates, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel;

    protected com.github.badoualy.telegram.tl.api.TLAbsInputUser userId;

    protected boolean kicked;


    public com.github.badoualy.telegram.tl.api.TLAbsInputChannel getChannel() {
        return channel;
    }

    public void setChannel(com.github.badoualy.telegram.tl.api.TLAbsInputChannel value) {
        this.channel = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsInputUser getUserId() {
        return userId;
    }

    public void setUserId(com.github.badoualy.telegram.tl.api.TLAbsInputUser value) {
        this.userId = value;
    }

    public boolean getKicked() {
        return kicked;
    }

    public void setKicked(boolean value) {
        this.kicked = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.channel, stream);
        writeTLObject(this.userId, stream);
        writeTLBool(this.kicked, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.channel = (com.github.badoualy.telegram.tl.api.TLAbsInputChannel)readTLObject(stream, context);
        this.userId = (com.github.badoualy.telegram.tl.api.TLAbsInputUser)readTLObject(stream, context);
        this.kicked = readTLBool(stream);
    }



    @Override
    public String toString() {
        return "channels.kickFromChannel#a672de14";
    }

}
