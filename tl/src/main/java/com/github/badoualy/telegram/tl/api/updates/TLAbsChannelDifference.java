package com.github.badoualy.telegram.tl.api.updates;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLChannelDifference}: updates.channelDifference#2064674e</li>
 * <li>{@link TLChannelDifferenceEmpty}: updates.channelDifferenceEmpty#3e11affb</li>
 * <li>{@link TLChannelDifferenceTooLong}: updates.channelDifferenceTooLong#410dee07</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsChannelDifference extends TLObject {

    protected int flags;

    protected boolean _final;

    protected int pts;

    protected Integer timeout;

    public TLAbsChannelDifference() {
    }

    public boolean getFinal() {
        return _final;
    }

    public void setFinal(boolean _final) {
        this._final = _final;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}
