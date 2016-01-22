package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUserStatusLastWeek extends TLAbsUserStatus {
    public static final int CLASS_ID = 0x7bf09fc;

    public TLUserStatusLastWeek() {
    }

    @Override
    public String toString() {
        return "userStatusLastWeek#7bf09fc";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
