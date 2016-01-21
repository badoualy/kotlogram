
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;


public class TLRequestChannelsEditAdmin extends TLMethod<com.github.badoualy.telegram.tl.api.TLAbsUpdates> {

    public static final int CLASS_ID = 0xeb7611d0;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestChannelsEditAdmin(        com.github.badoualy.telegram.tl.api.TLAbsInputChannel _channel,         com.github.badoualy.telegram.tl.api.TLAbsInputUser _userId,         com.github.badoualy.telegram.tl.api.TLAbsChannelParticipantRole _role) {
        this.channel = _channel;
        this.userId = _userId;
        this.role = _role;

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

    protected com.github.badoualy.telegram.tl.api.TLAbsChannelParticipantRole role;


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

    public com.github.badoualy.telegram.tl.api.TLAbsChannelParticipantRole getRole() {
        return role;
    }

    public void setRole(com.github.badoualy.telegram.tl.api.TLAbsChannelParticipantRole value) {
        this.role = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.channel, stream);
        writeTLObject(this.userId, stream);
        writeTLObject(this.role, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.channel = (com.github.badoualy.telegram.tl.api.TLAbsInputChannel)readTLObject(stream, context);
        this.userId = (com.github.badoualy.telegram.tl.api.TLAbsInputUser)readTLObject(stream, context);
        this.role = (com.github.badoualy.telegram.tl.api.TLAbsChannelParticipantRole)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "channels.editAdmin#eb7611d0";
    }

}
