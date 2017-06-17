package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelParticipantsBots extends TLAbsChannelParticipantsFilter {

    public static final int CONSTRUCTOR_ID = 0xb0d1865b;

    private final String _constructor = "channelParticipantsBots#b0d1865b";

    public TLChannelParticipantsBots() {
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
