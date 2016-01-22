package com.github.badoualy.telegram.tl.api.storage;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLFilePartial extends TLAbsFileType {
    public static final int CLASS_ID = 0x40bc6f52;

    public TLFilePartial() {
    }

    @Override
    public String toString() {
        return "storage.filePartial#40bc6f52";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
