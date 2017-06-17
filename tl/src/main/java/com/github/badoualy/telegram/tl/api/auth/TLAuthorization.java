package com.github.badoualy.telegram.tl.api.auth;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLAuthorization extends TLObject {

    public static final int CONSTRUCTOR_ID = 0xcd050916;

    protected int flags;

    protected Integer tmpSessions;

    protected TLAbsUser user;

    private final String _constructor = "auth.authorization#cd050916";

    public TLAuthorization() {
    }

    public TLAuthorization(Integer tmpSessions, TLAbsUser user) {
        this.tmpSessions = tmpSessions;
        this.user = user;
    }

    private void computeFlags() {
        flags = 0;
        flags = tmpSessions != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (tmpSessions == null) throwNullFieldException("tmpSessions", flags);
            writeInt(tmpSessions, stream);
        }
        writeTLObject(user, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        tmpSessions = (flags & 1) != 0 ? readInt(stream) : null;
        user = readTLObject(stream, context, TLAbsUser.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (tmpSessions == null) throwNullFieldException("tmpSessions", flags);
            size += SIZE_INT32;
        }
        size += user.computeSerializedSize();
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

    public Integer getTmpSessions() {
        return tmpSessions;
    }

    public void setTmpSessions(Integer tmpSessions) {
        this.tmpSessions = tmpSessions;
    }

    public TLAbsUser getUser() {
        return user;
    }

    public void setUser(TLAbsUser user) {
        this.user = user;
    }
}
