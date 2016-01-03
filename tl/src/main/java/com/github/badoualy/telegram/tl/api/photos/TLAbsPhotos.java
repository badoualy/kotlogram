
package com.github.badoualy.telegram.tl.api.photos;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public abstract class TLAbsPhotos extends TLObject {

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsPhoto> photos;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> users;


    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsPhoto> value) {
        this.photos = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> value) {
        this.users = value;
    }

}
