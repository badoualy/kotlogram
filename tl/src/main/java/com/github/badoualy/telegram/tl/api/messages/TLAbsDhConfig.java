package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLDhConfig}: messages.dhConfig#2c221edd</li>
 * <li>{@link TLDhConfigNotModified}: messages.dhConfigNotModified#c0e24635</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsDhConfig extends TLObject {

    protected TLBytes random;

    public TLAbsDhConfig() {
    }

    public TLBytes getRandom() {
        return random;
    }

    public void setRandom(TLBytes random) {
        this.random = random;
    }
}
