package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelParticipantsKicked extends TLAbsChannelParticipantsFilter {

    public static final int CONSTRUCTOR_ID = 0x3c37bb7a;

    private final String _constructor = "channelParticipantsKicked#3c37bb7a";

    public TLChannelParticipantsKicked() {
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
