package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelMessagesFilter extends TLAbsChannelMessagesFilter {
    public static final int CONSTRUCTOR_ID = 0xcd77d957;

    protected int flags;

    protected boolean importantOnly;

    protected boolean excludeNewMessages;

    protected TLVector<TLMessageRange> ranges;

    public TLChannelMessagesFilter() {
    }

    public TLChannelMessagesFilter(int flags, boolean importantOnly, boolean excludeNewMessages, TLVector<TLMessageRange> ranges) {
        this.flags = flags;
        this.importantOnly = importantOnly;
        this.excludeNewMessages = excludeNewMessages;
        this.ranges = ranges;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        flags = 0;
        flags = importantOnly ? (flags | 1) : (flags &~ 1);
        flags = excludeNewMessages ? (flags | 2) : (flags &~ 2);

        writeInt(flags, stream);
        if ((flags & 1) != 0) writeTLBool(importantOnly, stream);
        if ((flags & 2) != 0) writeTLBool(excludeNewMessages, stream);
        writeTLVector(ranges, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        importantOnly = (flags & 1) != 0;
        excludeNewMessages = (flags & 2) != 0;
        ranges = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "channelMessagesFilter#cd77d957";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public boolean getImportantOnly() {
        return importantOnly;
    }

    public void setImportantOnly(boolean importantOnly) {
        this.importantOnly = importantOnly;
    }

    public boolean getExcludeNewMessages() {
        return excludeNewMessages;
    }

    public void setExcludeNewMessages(boolean excludeNewMessages) {
        this.excludeNewMessages = excludeNewMessages;
    }

    public TLVector<TLMessageRange> getRanges() {
        return ranges;
    }

    public void setRanges(TLVector<TLMessageRange> ranges) {
        this.ranges = ranges;
    }
}
