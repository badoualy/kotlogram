package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLChannelParticipant}: channelParticipant#15ebac1d</li>
 * <li>{@link TLChannelParticipantCreator}: channelParticipantCreator#e3e2e1f9</li>
 * <li>{@link TLChannelParticipantEditor}: channelParticipantEditor#98192d61</li>
 * <li>{@link TLChannelParticipantKicked}: channelParticipantKicked#8cc5e69a</li>
 * <li>{@link TLChannelParticipantModerator}: channelParticipantModerator#91057fef</li>
 * <li>{@link TLChannelParticipantSelf}: channelParticipantSelf#a3289a6d</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsChannelParticipant extends TLObject {

    protected int userId;

    public TLAbsChannelParticipant() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
