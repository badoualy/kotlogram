
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLUpdateChannelGroup extends TLAbsUpdate {
    public static final int CLASS_ID = 0xc36c1e3c;

    public TLUpdateChannelGroup() {

    }


    public TLUpdateChannelGroup(        int _channelId,         com.github.badoualy.telegram.tl.api.TLMessageGroup _group) {
        this.channelId = _channelId;
        this.group = _group;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int channelId;

    protected com.github.badoualy.telegram.tl.api.TLMessageGroup group;


    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int value) {
        this.channelId = value;
    }

    public com.github.badoualy.telegram.tl.api.TLMessageGroup getGroup() {
        return group;
    }

    public void setGroup(com.github.badoualy.telegram.tl.api.TLMessageGroup value) {
        this.group = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.channelId, stream);
        writeTLObject(this.group, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.channelId = readInt(stream);
        this.group = (com.github.badoualy.telegram.tl.api.TLMessageGroup)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "updateChannelGroup#c36c1e3c";
    }

}
