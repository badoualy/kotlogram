package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLDocumentAttributeVideo extends TLAbsDocumentAttribute {

    public static final int CONSTRUCTOR_ID = 0xef02ce6;

    protected int flags;

    protected boolean roundMessage;

    protected int duration;

    protected int w;

    protected int h;

    private final String _constructor = "documentAttributeVideo#ef02ce6";

    public TLDocumentAttributeVideo() {
    }

    public TLDocumentAttributeVideo(boolean roundMessage, int duration, int w, int h) {
        this.roundMessage = roundMessage;
        this.duration = duration;
        this.w = w;
        this.h = h;
    }

    private void computeFlags() {
        flags = 0;
        flags = roundMessage ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(duration, stream);
        writeInt(w, stream);
        writeInt(h, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        roundMessage = (flags & 1) != 0;
        duration = readInt(stream);
        w = readInt(stream);
        h = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
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

    public boolean getRoundMessage() {
        return roundMessage;
    }

    public void setRoundMessage(boolean roundMessage) {
        this.roundMessage = roundMessage;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
}
