package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLChannelParticipantsAdmins}: channelParticipantsAdmins#b4608969</li>
 * <li>{@link TLChannelParticipantsBots}: channelParticipantsBots#b0d1865b</li>
 * <li>{@link TLChannelParticipantsKicked}: channelParticipantsKicked#3c37bb7a</li>
 * <li>{@link TLChannelParticipantsRecent}: channelParticipantsRecent#de3f3c79</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsChannelParticipantsFilter extends TLObject {

    public TLAbsChannelParticipantsFilter() {
    }
}
