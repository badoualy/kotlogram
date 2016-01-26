package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLEncryptedFileEmpty extends TLAbsEncryptedFile {
    public static final int CLASS_ID = 0xc21f497e;

    public TLEncryptedFileEmpty() {
    }

    @Override
    public String toString() {
        return "encryptedFileEmpty#c21f497e";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public final boolean isEmpty() {
        return true;
    }

    @Override
    public final boolean isNotEmpty() {
        return false;
    }
}
