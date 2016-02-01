package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeBoolean;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLReplyKeyboardForceReply extends TLAbsReplyMarkup {
    public static final int CONSTRUCTOR_ID = 0xf4108aa0;

    protected boolean singleUse;

    public TLReplyKeyboardForceReply() {
    }

    public TLReplyKeyboardForceReply(int flags, boolean singleUse, boolean selective) {
        this.flags = flags;
        this.singleUse = singleUse;
        this.selective = selective;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        flags = 0;
        flags = singleUse ? (flags | 2) : (flags &~ 2);
        flags = selective ? (flags | 4) : (flags &~ 4);

        writeInt(flags, stream);
        if ((flags & 2) != 0) writeBoolean(singleUse, stream);
        if ((flags & 4) != 0) writeBoolean(selective, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        singleUse = (flags & 2) != 0;
        selective = (flags & 4) != 0;
    }

    @Override
    public String toString() {
        return "replyKeyboardForceReply#f4108aa0";
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

    public boolean getSingleUse() {
        return singleUse;
    }

    public void setSingleUse(boolean singleUse) {
        this.singleUse = singleUse;
    }

    public boolean getSelective() {
        return selective;
    }

    public void setSelective(boolean selective) {
        this.selective = selective;
    }
}
