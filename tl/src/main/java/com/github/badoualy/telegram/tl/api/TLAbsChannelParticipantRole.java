package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLChannelRoleEditor}: channelRoleEditor#820bfe8c</li>
 * <li>{@link TLChannelRoleEmpty}: channelRoleEmpty#b285a0c6</li>
 * <li>{@link TLChannelRoleModerator}: channelRoleModerator#9618d975</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsChannelParticipantRole extends TLObject {

    public TLAbsChannelParticipantRole() {
    }
}
