package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLDraftMessage}: draftMessage#fd8e711f</li>
 * <li>{@link TLDraftMessageEmpty}: draftMessageEmpty#ba4baec5</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsDraftMessage extends TLObject {

    public TLAbsDraftMessage() {
    }

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLDraftMessage getAsDraftMessage() {
        return null;
    }
}
