package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateChannelGroup extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0xc36c1e3c;

    protected int channelId;

    protected TLMessageGroup group;

    public TLUpdateChannelGroup() {
    }

    public TLUpdateChannelGroup(int channelId, TLMessageGroup group) {
        this.channelId = channelId;
        this.group = group;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(channelId, stream);
        writeTLObject(group, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        channelId = readInt(stream);
        group = readTLObject(stream, context, TLMessageGroup.class, TLMessageGroup.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += group.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "updateChannelGroup#c36c1e3c";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLUpdateChannelGroup)) return false;
        if (object == this) return true;

        TLUpdateChannelGroup o = (TLUpdateChannelGroup) object;

        return channelId == o.channelId
                && (group == o.group || (group != null && o.group != null && group.equals(o.group)));
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public TLMessageGroup getGroup() {
        return group;
    }

    public void setGroup(TLMessageGroup group) {
        this.group = group;
    }
}
