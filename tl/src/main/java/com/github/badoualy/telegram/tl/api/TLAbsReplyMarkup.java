package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsReplyMarkup extends TLObject {
    protected int flags;

    protected boolean selective;

    public TLAbsReplyMarkup() {
    }

    private void computeFlags() {
        flags = 0;
        flags = selective ? (flags | 4) : (flags &~ 4);
    }

    public boolean getSelective() {
        return selective;
    }

    public void setSelective(boolean selective) {
        this.selective = selective;
    }
}
