package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import java.lang.Override;
import java.lang.String;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputEncryptedFileEmpty extends TLAbsInputEncryptedFile {
    public static final int CLASS_ID = 0x1837c364;

    public TLInputEncryptedFileEmpty() {
    }

    @Override
    public String toString() {
        return "inputEncryptedFileEmpty#1837c364";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
