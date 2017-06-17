package com.github.badoualy.telegram.tl.api.contacts;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsContactLink;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLLink extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x3ace484c;

    protected TLAbsContactLink myLink;

    protected TLAbsContactLink foreignLink;

    protected TLAbsUser user;

    private final String _constructor = "contacts.link#3ace484c";

    public TLLink() {
    }

    public TLLink(TLAbsContactLink myLink, TLAbsContactLink foreignLink, TLAbsUser user) {
        this.myLink = myLink;
        this.foreignLink = foreignLink;
        this.user = user;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(myLink, stream);
        writeTLObject(foreignLink, stream);
        writeTLObject(user, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        myLink = readTLObject(stream, context, TLAbsContactLink.class, -1);
        foreignLink = readTLObject(stream, context, TLAbsContactLink.class, -1);
        user = readTLObject(stream, context, TLAbsUser.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += myLink.computeSerializedSize();
        size += foreignLink.computeSerializedSize();
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

    public TLAbsUser getUser() {
        return user;
    }

    public void setUser(TLAbsUser user) {
        this.user = user;
    }
}
