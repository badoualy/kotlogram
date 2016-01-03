
package com.github.badoualy.telegram.tl.api.contacts;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public abstract class TLAbsBlocked extends TLObject {

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLContactBlocked> blocked;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> users;


    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLContactBlocked> getBlocked() {
        return blocked;
    }

    public void setBlocked(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLContactBlocked> value) {
        this.blocked = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> value) {
        this.users = value;
    }

}
