package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelParticipantsBots extends TLAbsChannelParticipantsFilter {
    public static final int CLASS_ID = 0xb0d1865b;

    public TLChannelParticipantsBots() {
    }

    @Override
    public String toString() {
        return "channelParticipantsBots#b0d1865b";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
