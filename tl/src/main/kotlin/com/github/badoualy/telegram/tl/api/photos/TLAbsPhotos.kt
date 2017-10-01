package com.github.badoualy.telegram.tl.api.photos

import com.github.badoualy.telegram.tl.api.TLAbsPhoto
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector

/**
 * Abstraction level for the following constructors:
 * * [photos.photos#8dca6aa5][TLPhotos]
 * * [photos.photosSlice#15051f54][TLPhotosSlice]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsPhotos : TLObject() {
    abstract var photos: TLObjectVector<TLAbsPhoto>

    abstract var users: TLObjectVector<TLAbsUser>
}
