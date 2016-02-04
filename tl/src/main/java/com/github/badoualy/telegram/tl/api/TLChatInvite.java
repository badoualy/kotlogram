package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeBoolean;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;

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

    public TLChatInvite() {
    }

    public TLChatInvite(boolean channel, boolean broadcast, boolean _public, boolean megagroup, String title) {
        this.channel = channel;
        this.broadcast = broadcast;
        this._public = _public;
        this.megagroup = megagroup;
        this.title = title;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        flags = 0;
        flags = channel ? (flags | 1) : (flags &~ 1);
        flags = broadcast ? (flags | 2) : (flags &~ 2);
        flags = _public ? (flags | 4) : (flags &~ 4);
        flags = megagroup ? (flags | 8) : (flags &~ 8);

        writeInt(flags, stream);
        if ((flags & 1) != 0) writeBoolean(channel, stream);
        if ((flags & 2) != 0) writeBoolean(broadcast, stream);
        if ((flags & 4) != 0) writeBoolean(_public, stream);
        if ((flags & 8) != 0) writeBoolean(megagroup, stream);
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
    public String toString() {
        return "chatInvite#93e99b60";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
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
