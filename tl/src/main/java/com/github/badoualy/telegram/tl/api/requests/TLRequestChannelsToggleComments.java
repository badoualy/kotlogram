
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


public class TLRequestChannelsToggleComments extends TLMethod<com.github.badoualy.telegram.tl.api.TLAbsUpdates> {

    public static final int CLASS_ID = 0xaaa29e88;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestChannelsToggleComments(        com.github.badoualy.telegram.tl.api.TLAbsInputChannel _channel,         boolean _enabled) {
        this.channel = _channel;
        this.enabled = _enabled;

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

    protected boolean enabled;


    public com.github.badoualy.telegram.tl.api.TLAbsInputChannel getChannel() {
        return channel;
    }

    public void setChannel(com.github.badoualy.telegram.tl.api.TLAbsInputChannel value) {
        this.channel = value;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean value) {
        this.enabled = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.channel, stream);
        writeTLBool(this.enabled, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.channel = (com.github.badoualy.telegram.tl.api.TLAbsInputChannel)readTLObject(stream, context);
        this.enabled = readTLBool(stream);
    }



    @Override
    public String toString() {
        return "channels.toggleComments#aaa29e88";
    }

}
