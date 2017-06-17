package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLEncryptedFileEmpty extends TLAbsEncryptedFile {

    public static final int CONSTRUCTOR_ID = 0xc21f497e;

    private final String _constructor = "encryptedFileEmpty#c21f497e";

    public TLEncryptedFileEmpty() {
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
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
