package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.core.TLObject

/**
 * Abstraction level for the following constructors:
 * * [userProfilePhoto#d559d8c8][TLUserProfilePhoto]
 * * [userProfilePhotoEmpty#4f11bae1][TLUserProfilePhotoEmpty]
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLAbsUserProfilePhoto : TLObject() {
    fun isEmpty(): Boolean = this is TLUserProfilePhotoEmpty

    fun isNotEmpty(): Boolean = this is TLUserProfilePhoto

    fun asUserProfilePhoto(): TLUserProfilePhoto? = this as? TLUserProfilePhoto
}
