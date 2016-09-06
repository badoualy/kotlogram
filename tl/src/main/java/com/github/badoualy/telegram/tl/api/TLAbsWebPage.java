package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLWebPage}: webPage#ca820ed7</li>
 * <li>{@link TLWebPageEmpty}: webPageEmpty#eb1477e8</li>
 * <li>{@link TLWebPagePending}: webPagePending#c586da1c</li>
 * </ul>
 *
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
