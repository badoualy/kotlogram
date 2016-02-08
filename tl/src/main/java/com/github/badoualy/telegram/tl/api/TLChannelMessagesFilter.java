package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeBoolean;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelMessagesFilter extends TLAbsChannelMessagesFilter {
    public static final int CONSTRUCTOR_ID = 0xcd77d957;

    protected int flags;

    protected boolean importantOnly;

    protected boolean excludeNewMessages;

    protected TLVector<? extends TLMessageRange> ranges;

    public TLChannelMessagesFilter() {
    }

    public TLChannelMessagesFilter(boolean importantOnly, boolean excludeNewMessages, TLVector<? extends TLMessageRange> ranges) {
        this.importantOnly = importantOnly;
        this.excludeNewMessages = excludeNewMessages;
        this.ranges = ranges;
    }

    private void computeFlags() {
        flags = 0;
        flags = importantOnly ? (flags | 1) : (flags &~ 1);
        flags = excludeNewMessages ? (flags | 2) : (flags &~ 2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) writeBoolean(importantOnly, stream);
        if ((flags & 2) != 0) writeBoolean(excludeNewMessages, stream);
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
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) size += SIZE_BOOLEAN;
        if ((flags & 2) != 0) size += SIZE_BOOLEAN;
        size += ranges.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "channelMessagesFilter#cd77d957";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
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

    public TLVector<? extends TLMessageRange> getRanges() {
        return ranges;
    }

    public void setRanges(TLVector<? extends TLMessageRange> ranges) {
        this.ranges = ranges;
    }
}
