package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelParticipantsKicked extends TLAbsChannelParticipantsFilter {
    public static final int CLASS_ID = 0x3c37bb7a;

    public TLChannelParticipantsKicked() {
    }

    @Override
    public String toString() {
        return "channelParticipantsKicked#3c37bb7a";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
