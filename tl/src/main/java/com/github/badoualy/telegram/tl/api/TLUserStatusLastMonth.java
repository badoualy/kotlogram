package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUserStatusLastMonth extends TLAbsUserStatus {
    public static final int CLASS_ID = 0x77ebc742;

    public TLUserStatusLastMonth() {
    }

    @Override
    public String toString() {
        return "userStatusLastMonth#77ebc742";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
