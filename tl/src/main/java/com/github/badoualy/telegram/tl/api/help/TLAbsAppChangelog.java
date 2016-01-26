package com.github.badoualy.telegram.tl.api.help;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsAppChangelog extends TLObject {
    public TLAbsAppChangelog() {
    }

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLAppChangelog getAsAppChangelog() {
        return null;
    }
}
