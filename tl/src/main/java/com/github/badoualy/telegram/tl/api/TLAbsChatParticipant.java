package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLChatParticipant}: chatParticipant#c8d7493e</li>
 * <li>{@link TLChatParticipantAdmin}: chatParticipantAdmin#e2d6e436</li>
 * <li>{@link TLChatParticipantCreator}: chatParticipantCreator#da13538a</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsChatParticipant extends TLObject {

    protected int userId;

    public TLAbsChatParticipant() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
