package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPeerSelf extends TLAbsInputPeer {
    public static final int CLASS_ID = 0x7da07ec9;

    public TLInputPeerSelf() {
    }

    @Override
    public String toString() {
        return "inputPeerSelf#7da07ec9";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
