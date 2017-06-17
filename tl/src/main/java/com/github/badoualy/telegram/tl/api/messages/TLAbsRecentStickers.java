package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLRecentStickers}: messages.recentStickers#5ce20970</li>
 * <li>{@link TLRecentStickersNotModified}: messages.recentStickersNotModified#b17f890</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsRecentStickers extends TLObject {

    public TLAbsRecentStickers() {
    }
}
