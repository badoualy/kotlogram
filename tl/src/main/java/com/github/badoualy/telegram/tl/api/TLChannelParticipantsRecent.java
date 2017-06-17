package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelParticipantsRecent extends TLAbsChannelParticipantsFilter {

    public static final int CONSTRUCTOR_ID = 0xde3f3c79;

    private final String _constructor = "channelParticipantsRecent#de3f3c79";

    public TLChannelParticipantsRecent() {
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
