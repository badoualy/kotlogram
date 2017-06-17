package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLUpdateShort}: updateShort#78d4dec1</li>
 * <li>{@link TLUpdateShortChatMessage}: updateShortChatMessage#16812688</li>
 * <li>{@link TLUpdateShortMessage}: updateShortMessage#914fbf11</li>
 * <li>{@link TLUpdateShortSentMessage}: updateShortSentMessage#11f1331c</li>
 * <li>{@link TLUpdates}: updates#74ae4240</li>
 * <li>{@link TLUpdatesCombined}: updatesCombined#725b04c3</li>
 * <li>{@link TLUpdatesTooLong}: updatesTooLong#e317af7e</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsUpdates extends TLObject {

    public TLAbsUpdates() {
    }
}
