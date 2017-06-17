package com.github.badoualy.telegram.tl.api.photos;

import com.github.badoualy.telegram.tl.api.TLAbsPhoto;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLPhotos}: photos.photos#8dca6aa5</li>
 * <li>{@link TLPhotosSlice}: photos.photosSlice#15051f54</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsPhotos extends TLObject {

    protected TLVector<TLAbsPhoto> photos;

    protected TLVector<TLAbsUser> users;

    public TLAbsPhotos() {
    }

    public TLVector<TLAbsPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(TLVector<TLAbsPhoto> photos) {
        this.photos = photos;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
