package com.github.badoualy.telegram.tl.api.account;

import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLNoPassword}: account.noPassword#96dabc18</li>
 * <li>{@link TLPassword}: account.password#7c18141c</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsPassword extends TLObject {

    protected TLBytes newSalt;

    protected String emailUnconfirmedPattern;

    public TLAbsPassword() {
    }

    public TLBytes getNewSalt() {
        return newSalt;
    }

    public void setNewSalt(TLBytes newSalt) {
        this.newSalt = newSalt;
    }

    public String getEmailUnconfirmedPattern() {
        return emailUnconfirmedPattern;
    }

    public void setEmailUnconfirmedPattern(String emailUnconfirmedPattern) {
        this.emailUnconfirmedPattern = emailUnconfirmedPattern;
    }
}
