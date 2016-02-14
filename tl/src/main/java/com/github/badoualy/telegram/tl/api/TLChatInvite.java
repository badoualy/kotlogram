package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChatInvite extends TLAbsChatInvite {
    public static final int CONSTRUCTOR_ID = 0x93e99b60;

    protected int flags;

    protected boolean channel;

    protected boolean broadcast;

    protected boolean _public;

    protected boolean megagroup;

    protected String title;

    private final String _constructor = "chatInvite#93e99b60";

    public TLChatInvite() {
    }

    public TLChatInvite(boolean channel, boolean broadcast, boolean _public, boolean megagroup, String title) {
        this.channel = channel;
        this.broadcast = broadcast;
        this._public = _public;
        this.megagroup = megagroup;
        this.title = title;
    }

    private void computeFlags() {
        flags = 0;
        flags = channel ? (flags | 1) : (flags &~ 1);
        flags = broadcast ? (flags | 2) : (flags &~ 2);
        flags = _public ? (flags | 4) : (flags &~ 4);
        flags = megagroup ? (flags | 8) : (flags &~ 8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(title, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        channel = (flags & 1) != 0;
        broadcast = (flags & 2) != 0;
        _public = (flags & 4) != 0;
        megagroup = (flags & 8) != 0;
        title = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(title);
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLChatInvite)) return false;
        if (object == this) return true;

        TLChatInvite o = (TLChatInvite) object;

        return flags == o.flags
                && channel == o.channel
                && broadcast == o.broadcast
                && _public == o._public
                && megagroup == o.megagroup
                && (title == o.title || (title != null && o.title != null && title.equals(o.title)));
    }

    public boolean getChannel() {
        return channel;
    }

    public void setChannel(boolean channel) {
        this.channel = channel;
    }

    public boolean getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(boolean broadcast) {
        this.broadcast = broadcast;
    }

    public boolean getPublic() {
        return _public;
    }

    public void setPublic(boolean _public) {
        this._public = _public;
    }

    public boolean getMegagroup() {
        return megagroup;
    }

    public void setMegagroup(boolean megagroup) {
        this.megagroup = megagroup;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
