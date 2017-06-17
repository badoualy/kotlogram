package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLUserProfilePhoto}: userProfilePhoto#d559d8c8</li>
 * <li>{@link TLUserProfilePhotoEmpty}: userProfilePhotoEmpty#4f11bae1</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsUserProfilePhoto extends TLObject {

    public TLAbsUserProfilePhoto() {
    }

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLUserProfilePhoto getAsUserProfilePhoto() {
        return null;
    }
}
