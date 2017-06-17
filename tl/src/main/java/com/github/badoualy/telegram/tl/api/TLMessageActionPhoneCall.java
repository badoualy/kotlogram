package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageActionPhoneCall extends TLAbsMessageAction {

    public static final int CONSTRUCTOR_ID = 0x80e11a7f;

    protected int flags;

    protected long callId;

    protected TLAbsPhoneCallDiscardReason reason;

    protected Integer duration;

    private final String _constructor = "messageActionPhoneCall#80e11a7f";

    public TLMessageActionPhoneCall() {
    }

    public TLMessageActionPhoneCall(long callId, TLAbsPhoneCallDiscardReason reason, Integer duration) {
        this.callId = callId;
        this.reason = reason;
        this.duration = duration;
    }

    private void computeFlags() {
        flags = 0;
        flags = reason != null ? (flags | 1) : (flags & ~1);
        flags = duration != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(callId, stream);
        if ((flags & 1) != 0) {
            if (reason == null) throwNullFieldException("reason", flags);
            writeTLObject(reason, stream);
        }
        if ((flags & 2) != 0) {
            if (duration == null) throwNullFieldException("duration", flags);
            writeInt(duration, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        callId = readLong(stream);
        reason = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsPhoneCallDiscardReason.class, -1) : null;
        duration = (flags & 2) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        if ((flags & 1) != 0) {
            if (reason == null) throwNullFieldException("reason", flags);
            size += reason.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (duration == null) throwNullFieldException("duration", flags);
            size += SIZE_INT32;
        }
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

    public long getCallId() {
        return callId;
    }

    public void setCallId(long callId) {
        this.callId = callId;
    }

    public TLAbsPhoneCallDiscardReason getReason() {
        return reason;
    }

    public void setReason(TLAbsPhoneCallDiscardReason reason) {
        this.reason = reason;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
