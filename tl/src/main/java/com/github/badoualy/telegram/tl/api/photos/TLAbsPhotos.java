package com.github.badoualy.telegram.tl.api.photos;

import com.github.badoualy.telegram.tl.api.TLAbsPhoto;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsPhotos extends TLObject {
    protected TLVector<? extends TLAbsPhoto> photos;

    protected TLVector<? extends TLAbsUser> users;

    public TLAbsPhotos() {
    }

    public TLVector<? extends TLAbsPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(TLVector<? extends TLAbsPhoto> photos) {
        this.photos = photos;
    }

    public TLVector<? extends TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<? extends TLAbsUser> users) {
        this.users = users;
    }
}
