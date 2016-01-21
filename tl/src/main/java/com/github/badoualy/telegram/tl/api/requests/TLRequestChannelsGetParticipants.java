
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;


public class TLRequestChannelsGetParticipants extends TLMethod<com.github.badoualy.telegram.tl.api.channels.TLChannelParticipants> {

    public static final int CLASS_ID = 0x24d98f92;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestChannelsGetParticipants(        com.github.badoualy.telegram.tl.api.TLAbsInputChannel _channel,         com.github.badoualy.telegram.tl.api.TLAbsChannelParticipantsFilter _filter,         int _offset,         int _limit) {
        this.channel = _channel;
        this.filter = _filter;
        this.offset = _offset;
        this.limit = _limit;

    }



    public com.github.badoualy.telegram.tl.api.channels.TLChannelParticipants deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.channels.TLChannelParticipants) {
            return (com.github.badoualy.telegram.tl.api.channels.TLChannelParticipants)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.channels.TLChannelParticipants, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputChannel channel;

    protected com.github.badoualy.telegram.tl.api.TLAbsChannelParticipantsFilter filter;

    protected int offset;

    protected int limit;


    public com.github.badoualy.telegram.tl.api.TLAbsInputChannel getChannel() {
        return channel;
    }

    public void setChannel(com.github.badoualy.telegram.tl.api.TLAbsInputChannel value) {
        this.channel = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsChannelParticipantsFilter getFilter() {
        return filter;
    }

    public void setFilter(com.github.badoualy.telegram.tl.api.TLAbsChannelParticipantsFilter value) {
        this.filter = value;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int value) {
        this.offset = value;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int value) {
        this.limit = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.channel, stream);
        writeTLObject(this.filter, stream);
        writeInt(this.offset, stream);
        writeInt(this.limit, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.channel = (com.github.badoualy.telegram.tl.api.TLAbsInputChannel)readTLObject(stream, context);
        this.filter = (com.github.badoualy.telegram.tl.api.TLAbsChannelParticipantsFilter)readTLObject(stream, context);
        this.offset = readInt(stream);
        this.limit = readInt(stream);
    }



    @Override
    public String toString() {
        return "channels.getParticipants#24d98f92";
    }

}
