package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLChatInviteEmpty}: chatInviteEmpty#69df3769</li>
 * <li>{@link TLChatInviteExported}: chatInviteExported#fc2e05bc</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsExportedChatInvite extends TLObject {

    public TLAbsExportedChatInvite() {
    }

    public abstract boolean isEmpty();

    public abstract boolean isNotEmpty();

    public TLChatInviteExported getAsChatInviteExported() {
        return null;
    }
}
