package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsWebPage extends TLObject {
    protected long id;

    public TLAbsWebPage() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
