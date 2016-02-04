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
public class TLReplyKeyboardHide extends TLAbsReplyMarkup {
    public static final int CONSTRUCTOR_ID = 0xa03e5b85;

    public TLReplyKeyboardHide() {
    }

    public TLReplyKeyboardHide(boolean selective) {
        this.selective = selective;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        flags = 0;
        flags = selective ? (flags | 4) : (flags &~ 4);

        writeInt(flags, stream);
        if ((flags & 4) != 0) writeBoolean(selective, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        selective = (flags & 4) != 0;
    }

    @Override
    public String toString() {
        return "replyKeyboardHide#a03e5b85";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public boolean getSelective() {
        return selective;
    }

    public void setSelective(boolean selective) {
        this.selective = selective;
    }
}
