package com.github.badoualy.telegram.tl.api.contacts;

import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLContactBlocked;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsBlocked extends TLObject {
    protected TLVector<? extends TLContactBlocked> blocked;

    protected TLVector<? extends TLAbsUser> users;

    public TLAbsBlocked() {
    }

    public TLVector<? extends TLContactBlocked> getBlocked() {
        return blocked;
    }

    public void setBlocked(TLVector<? extends TLContactBlocked> blocked) {
        this.blocked = blocked;
    }

    public TLVector<? extends TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<? extends TLAbsUser> users) {
        this.users = users;
    }
}
