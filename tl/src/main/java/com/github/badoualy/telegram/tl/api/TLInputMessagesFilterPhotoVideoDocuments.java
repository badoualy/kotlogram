package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMessagesFilterPhotoVideoDocuments extends TLAbsMessagesFilter {

    public static final int CONSTRUCTOR_ID = 0xd95e73bb;

    private final String _constructor = "inputMessagesFilterPhotoVideoDocuments#d95e73bb";

    public TLInputMessagesFilterPhotoVideoDocuments() {
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
