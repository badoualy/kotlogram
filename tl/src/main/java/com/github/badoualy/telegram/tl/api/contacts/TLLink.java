package com.github.badoualy.telegram.tl.api.contacts;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsContactLink;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLLink extends TLObject {
    public static final int CLASS_ID = 0x3ace484c;

    protected TLAbsContactLink myLink;

    protected TLAbsContactLink foreignLink;

    protected TLAbsUser user;

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
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        myLink = (com.github.badoualy.telegram.tl.api.TLAbsContactLink) readTLObject(stream, context);
        foreignLink = (com.github.badoualy.telegram.tl.api.TLAbsContactLink) readTLObject(stream, context);
        user = (com.github.badoualy.telegram.tl.api.TLAbsUser) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "contacts.link#3ace484c";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
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
