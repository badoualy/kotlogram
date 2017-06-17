package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMessagesFilterPhotoVideo extends TLAbsMessagesFilter {

    public static final int CONSTRUCTOR_ID = 0x56e9f0e4;

    private final String _constructor = "inputMessagesFilterPhotoVideo#56e9f0e4";

    public TLInputMessagesFilterPhotoVideo() {
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
