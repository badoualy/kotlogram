package com.github.badoualy.telegram.tl.api.account;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsPrivacyRule;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPrivacyRules extends TLObject {
    public static final int CLASS_ID = 0x554abb6f;

    protected TLVector<TLAbsPrivacyRule> rules;

    protected TLVector<TLAbsUser> users;

    public TLPrivacyRules() {
    }

    public TLPrivacyRules(TLVector<TLAbsPrivacyRule> rules, TLVector<TLAbsUser> users) {
        this.rules = rules;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(rules, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        rules = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "account.privacyRules#554abb6f";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLVector<TLAbsPrivacyRule> getRules() {
        return rules;
    }

    public void setRules(TLVector<TLAbsPrivacyRule> rules) {
        this.rules = rules;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
