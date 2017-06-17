package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputEncryptedFileEmpty extends TLAbsInputEncryptedFile {

    public static final int CONSTRUCTOR_ID = 0x1837c364;

    private final String _constructor = "inputEncryptedFileEmpty#1837c364";

    public TLInputEncryptedFileEmpty() {
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
