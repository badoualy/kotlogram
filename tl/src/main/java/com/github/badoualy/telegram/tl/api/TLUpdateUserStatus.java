package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateUserStatus extends TLAbsUpdate {
    public static final int CLASS_ID = 0x1bfbd823;

    protected int userId;

    protected TLAbsUserStatus status;

    public TLUpdateUserStatus() {
    }

    public TLUpdateUserStatus(int userId, TLAbsUserStatus status) {
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
        return "updateUserStatus#1bfbd823";
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
