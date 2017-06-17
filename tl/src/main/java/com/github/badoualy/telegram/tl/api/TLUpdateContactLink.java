package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

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
public class TLUpdateContactLink extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x9d2e67c5;

    protected int userId;

    protected TLAbsContactLink myLink;

    protected TLAbsContactLink foreignLink;

    private final String _constructor = "updateContactLink#9d2e67c5";

    public TLUpdateContactLink() {
    }

    public TLUpdateContactLink(int userId, TLAbsContactLink myLink, TLAbsContactLink foreignLink) {
        this.userId = userId;
        this.myLink = myLink;
        this.foreignLink = foreignLink;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(userId, stream);
        writeTLObject(myLink, stream);
        writeTLObject(foreignLink, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        userId = readInt(stream);
        myLink = readTLObject(stream, context, TLAbsContactLink.class, -1);
        foreignLink = readTLObject(stream, context, TLAbsContactLink.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += myLink.computeSerializedSize();
        size += foreignLink.computeSerializedSize();
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public TLAbsContactLink getMyLink() {
        return myLink;
    }

    public void setMyLink(TLAbsContactLink myLink) {
        this.myLink = myLink;
    }

    public TLAbsContactLink getForeignLink() {
        return foreignLink;
    }

    public void setForeignLink(TLAbsContactLink foreignLink) {
        this.foreignLink = foreignLink;
    }
}
