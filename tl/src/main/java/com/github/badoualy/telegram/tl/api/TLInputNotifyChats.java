package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputNotifyChats extends TLAbsInputNotifyPeer {
    public static final int CLASS_ID = 0x4a95e84e;

    public TLInputNotifyChats() {
    }

    @Override
    public String toString() {
        return "inputNotifyChats#4a95e84e";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
