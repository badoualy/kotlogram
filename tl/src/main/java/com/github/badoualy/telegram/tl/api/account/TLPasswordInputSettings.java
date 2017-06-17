package com.github.badoualy.telegram.tl.api.account;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPasswordInputSettings extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x86916deb;

    protected int flags;

    protected TLBytes newSalt;

    protected TLBytes newPasswordHash;

    protected String hint;

    protected String email;

    private final String _constructor = "account.passwordInputSettings#86916deb";

    public TLPasswordInputSettings() {
    }

    public TLPasswordInputSettings(TLBytes newSalt, TLBytes newPasswordHash, String hint, String email) {
        this.newSalt = newSalt;
        this.newPasswordHash = newPasswordHash;
        this.hint = hint;
        this.email = email;
    }

    private void computeFlags() {
        flags = 0;
        flags = newSalt != null ? (flags | 1) : (flags & ~1);
        flags = newPasswordHash != null ? (flags | 1) : (flags & ~1);
        flags = hint != null ? (flags | 1) : (flags & ~1);
        flags = email != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (newSalt == null) throwNullFieldException("newSalt", flags);
            writeTLBytes(newSalt, stream);
        }
        if ((flags & 1) != 0) {
            if (newPasswordHash == null) throwNullFieldException("newPasswordHash", flags);
            writeTLBytes(newPasswordHash, stream);
        }
        if ((flags & 1) != 0) {
            if (hint == null) throwNullFieldException("hint", flags);
            writeString(hint, stream);
        }
        if ((flags & 2) != 0) {
            if (email == null) throwNullFieldException("email", flags);
            writeString(email, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        newSalt = (flags & 1) != 0 ? readTLBytes(stream, context) : null;
        newPasswordHash = (flags & 1) != 0 ? readTLBytes(stream, context) : null;
        hint = (flags & 1) != 0 ? readTLString(stream) : null;
        email = (flags & 2) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (newSalt == null) throwNullFieldException("newSalt", flags);
            size += computeTLBytesSerializedSize(newSalt);
        }
        if ((flags & 1) != 0) {
            if (newPasswordHash == null) throwNullFieldException("newPasswordHash", flags);
            size += computeTLBytesSerializedSize(newPasswordHash);
        }
        if ((flags & 1) != 0) {
            if (hint == null) throwNullFieldException("hint", flags);
            size += computeTLStringSerializedSize(hint);
        }
        if ((flags & 2) != 0) {
            if (email == null) throwNullFieldException("email", flags);
            size += computeTLStringSerializedSize(email);
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

    public TLBytes getNewSalt() {
        return newSalt;
    }

    public void setNewSalt(TLBytes newSalt) {
        this.newSalt = newSalt;
    }

    public TLBytes getNewPasswordHash() {
        return newPasswordHash;
    }

    public void setNewPasswordHash(TLBytes newPasswordHash) {
        this.newPasswordHash = newPasswordHash;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
