package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.updates.TLAbsDifference;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestUpdatesGetDifference extends TLMethod<TLAbsDifference> {

    public static final int CONSTRUCTOR_ID = 0x25939651;

    protected int flags;

    protected int pts;

    protected Integer ptsTotalLimit;

    protected int date;

    protected int qts;

    private final String _constructor = "updates.getDifference#25939651";

    public TLRequestUpdatesGetDifference() {
    }

    public TLRequestUpdatesGetDifference(int pts, Integer ptsTotalLimit, int date, int qts) {
        this.pts = pts;
        this.ptsTotalLimit = ptsTotalLimit;
        this.date = date;
        this.qts = qts;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsDifference deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsDifference)) {
            throw new IOException(
                    "Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response
                            .getClass().getCanonicalName());
        }
        return (TLAbsDifference) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = ptsTotalLimit != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(pts, stream);
        if ((flags & 1) != 0) {
            if (ptsTotalLimit == null) throwNullFieldException("ptsTotalLimit", flags);
            writeInt(ptsTotalLimit, stream);
        }
        writeInt(date, stream);
        writeInt(qts, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        pts = readInt(stream);
        ptsTotalLimit = (flags & 1) != 0 ? readInt(stream) : null;
        date = readInt(stream);
        qts = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (ptsTotalLimit == null) throwNullFieldException("ptsTotalLimit", flags);
            size += SIZE_INT32;
        }
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

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public Integer getPtsTotalLimit() {
        return ptsTotalLimit;
    }

    public void setPtsTotalLimit(Integer ptsTotalLimit) {
        this.ptsTotalLimit = ptsTotalLimit;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getQts() {
        return qts;
    }

    public void setQts(int qts) {
        this.qts = qts;
    }
}
