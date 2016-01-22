package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPeerNotifyEventsAll extends TLAbsPeerNotifyEvents {
    public static final int CLASS_ID = 0x6d1ded88;

    public TLPeerNotifyEventsAll() {
    }

    @Override
    public String toString() {
        return "peerNotifyEventsAll#6d1ded88";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
