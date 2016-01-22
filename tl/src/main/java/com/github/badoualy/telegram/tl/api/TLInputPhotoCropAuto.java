package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPhotoCropAuto extends TLAbsInputPhotoCrop {
    public static final int CLASS_ID = 0xade6b004;

    public TLInputPhotoCropAuto() {
    }

    @Override
    public String toString() {
        return "inputPhotoCropAuto#ade6b004";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
