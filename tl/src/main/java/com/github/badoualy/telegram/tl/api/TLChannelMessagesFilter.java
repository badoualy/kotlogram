
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLChannelMessagesFilter extends TLAbsChannelMessagesFilter {
    public static final int CLASS_ID = 0xcd77d957;

    public TLChannelMessagesFilter() {

    }


    public TLChannelMessagesFilter(        int _flags,         boolean _importantOnly,         boolean _excludeNewMessages,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLMessageRange> _ranges) {
        this.flags = _flags;
        this.importantOnly = _importantOnly;
        this.excludeNewMessages = _excludeNewMessages;
        this.ranges = _ranges;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int flags;

    protected boolean importantOnly;

    protected boolean excludeNewMessages;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLMessageRange> ranges;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public boolean getImportantOnly() {
        return importantOnly;
    }

    public void setImportantOnly(boolean value) {
        this.importantOnly = value;
    }

    public boolean getExcludeNewMessages() {
        return excludeNewMessages;
    }

    public void setExcludeNewMessages(boolean value) {
        this.excludeNewMessages = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLMessageRange> getRanges() {
        return ranges;
    }

    public void setRanges(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLMessageRange> value) {
        this.ranges = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        flags = importantOnly ? (flags | 1) : (flags &~ 1);
        flags = excludeNewMessages ? (flags | 2) : (flags &~ 2);
        writeInt(this.flags, stream);
        if ((this.flags & 1) != 0)
            writeTLBool(this.importantOnly, stream);
        if ((this.flags & 2) != 0)
            writeTLBool(this.excludeNewMessages, stream);
        writeTLVector(this.ranges, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.importantOnly = (this.flags & 1) != 0;
        this.excludeNewMessages = (this.flags & 2) != 0;
        this.ranges = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "channelMessagesFilter#cd77d957";
    }

}
