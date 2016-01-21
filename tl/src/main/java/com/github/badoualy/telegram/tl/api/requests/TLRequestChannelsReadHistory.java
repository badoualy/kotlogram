
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;


public class TLRequestChannelsReadHistory extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0xcc104937;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestChannelsReadHistory(        com.github.badoualy.telegram.tl.api.TLAbsInputChannel _channel,         int _maxId) {
        this.channel = _channel;
        this.maxId = _maxId;

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
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel;

    protected int maxId;


    public com.github.badoualy.telegram.tl.api.TLAbsInputChannel getChannel() {
        return channel;
    }

    public void setChannel(com.github.badoualy.telegram.tl.api.TLAbsInputChannel value) {
        this.channel = value;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int value) {
        this.maxId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.channel, stream);
        writeInt(this.maxId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.channel = (com.github.badoualy.telegram.tl.api.TLAbsInputChannel)readTLObject(stream, context);
        this.maxId = readInt(stream);
    }



    @Override
    public String toString() {
        return "channels.readHistory#cc104937";
    }

}
