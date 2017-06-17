package com.github.badoualy.telegram.tl.api.updates;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

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
public class TLState extends TLObject {

    public static final int CONSTRUCTOR_ID = 0xa56c2a3e;

    protected int pts;

    protected int qts;

    protected int date;

    protected int seq;

    protected int unreadCount;

    private final String _constructor = "updates.state#a56c2a3e";

    public TLState() {
    }

    public TLState(int pts, int qts, int date, int seq, int unreadCount) {
        this.pts = pts;
        this.qts = qts;
        this.date = date;
        this.seq = seq;
        this.unreadCount = unreadCount;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(pts, stream);
        writeInt(qts, stream);
        writeInt(date, stream);
        writeInt(seq, stream);
        writeInt(unreadCount, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        pts = readInt(stream);
        qts = readInt(stream);
        date = readInt(stream);
        seq = readInt(stream);
        unreadCount = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
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

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getQts() {
        return qts;
    }

    public void setQts(int qts) {
        this.qts = qts;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }
}
