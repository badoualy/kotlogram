package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelMessagesFilterCollapsed extends TLAbsChannelMessagesFilter {
    public static final int CLASS_ID = 0xfa01232e;

    public TLChannelMessagesFilterCollapsed() {
    }

    @Override
    public String toString() {
        return "channelMessagesFilterCollapsed#fa01232e";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
