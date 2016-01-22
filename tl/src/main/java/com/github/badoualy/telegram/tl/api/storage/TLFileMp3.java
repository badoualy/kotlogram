package com.github.badoualy.telegram.tl.api.storage;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLFileMp3 extends TLAbsFileType {
    public static final int CLASS_ID = 0x528a0677;

    public TLFileMp3() {
    }

    @Override
    public String toString() {
        return "storage.fileMp3#528a0677";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
