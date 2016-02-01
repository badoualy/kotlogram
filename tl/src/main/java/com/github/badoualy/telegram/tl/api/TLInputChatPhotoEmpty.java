package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputChatPhotoEmpty extends TLAbsInputChatPhoto {
    public static final int CONSTRUCTOR_ID = 0x1ca48f57;

    public TLInputChatPhotoEmpty() {
    }

    @Override
    public String toString() {
        return "inputChatPhotoEmpty#1ca48f57";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
