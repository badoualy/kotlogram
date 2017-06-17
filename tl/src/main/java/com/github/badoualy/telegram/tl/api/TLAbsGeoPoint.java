package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLGeoPoint}: geoPoint#2049d70c</li>
 * <li>{@link TLGeoPointEmpty}: geoPointEmpty#1117dd5f</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsGeoPoint extends TLObject {

    public TLAbsGeoPoint() {
    }

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLGeoPoint getAsGeoPoint() {
        return null;
    }
}
