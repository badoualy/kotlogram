package com.github.badoualy.telegram.tl.api.help;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLAppChangelog}: help.appChangelog#4668e6bd</li>
 * <li>{@link TLAppChangelogEmpty}: help.appChangelogEmpty#af7e0394</li>
 * </ul>
 *
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
