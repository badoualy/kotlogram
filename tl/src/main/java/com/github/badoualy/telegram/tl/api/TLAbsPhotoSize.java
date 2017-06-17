package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLPhotoCachedSize}: photoCachedSize#e9a734fa</li>
 * <li>{@link TLPhotoSize}: photoSize#77bfb61b</li>
 * <li>{@link TLPhotoSizeEmpty}: photoSizeEmpty#e17e23c</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsPhotoSize extends TLObject {

    protected String type;

    public TLAbsPhotoSize() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
