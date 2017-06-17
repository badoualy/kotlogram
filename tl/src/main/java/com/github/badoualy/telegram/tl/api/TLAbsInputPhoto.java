package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLInputPhoto}: inputPhoto#fb95c6c4</li>
 * <li>{@link TLInputPhotoEmpty}: inputPhotoEmpty#1cd7bf0d</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsInputPhoto extends TLObject {

    public TLAbsInputPhoto() {
    }

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLInputPhoto getAsInputPhoto() {
        return null;
    }

    public static TLInputPhotoEmpty newEmpty() {
        return new TLInputPhotoEmpty();
    }

    public static TLInputPhoto newNotEmpty() {
        return new TLInputPhoto();
    }
}
