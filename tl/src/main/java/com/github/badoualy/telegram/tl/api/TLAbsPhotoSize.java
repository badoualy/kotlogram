package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
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
