package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLChannel}: channel#a14dca52</li>
 * <li>{@link TLChannelForbidden}: channelForbidden#8537784f</li>
 * <li>{@link TLChat}: chat#d91cdd54</li>
 * <li>{@link TLChatEmpty}: chatEmpty#9ba2d800</li>
 * <li>{@link TLChatForbidden}: chatForbidden#7328bdb</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsChat extends TLObject {

    protected int id;

    public TLAbsChat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
