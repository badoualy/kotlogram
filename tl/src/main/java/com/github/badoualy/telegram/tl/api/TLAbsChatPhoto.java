package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLChatPhoto}: chatPhoto#6153276a</li>
 * <li>{@link TLChatPhotoEmpty}: chatPhotoEmpty#37c1011c</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsChatPhoto extends TLObject {

    public TLAbsChatPhoto() {
    }

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLChatPhoto getAsChatPhoto() {
        return null;
    }
}
