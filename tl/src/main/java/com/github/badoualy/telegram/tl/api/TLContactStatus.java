package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLContactStatus extends TLObject {
    public static final int CLASS_ID = 0xd3680c61;

    protected int userId;

    protected TLAbsUserStatus status;

    public TLContactStatus() {
    }

    public TLContactStatus(int userId, TLAbsUserStatus status) {
        this.userId = userId;
        this.status = status;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(userId, stream);
        writeTLObject(status, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        userId = readInt(stream);
        status = (com.github.badoualy.telegram.tl.api.TLAbsUserStatus) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "contactStatus#d3680c61";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public TLAbsUserStatus getStatus() {
        return status;
    }

    public void setStatus(TLAbsUserStatus status) {
        this.status = status;
    }
}
