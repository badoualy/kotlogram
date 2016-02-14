package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMessagesFilterAudioDocuments extends TLAbsMessagesFilter {
    public static final int CONSTRUCTOR_ID = 0x5afbf764;

    private final String _constructor = "inputMessagesFilterAudioDocuments#5afbf764";

    public TLInputMessagesFilterAudioDocuments() {
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
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputMessagesFilterAudioDocuments)) return false;
        if (object == this) return true;

        TLInputMessagesFilterAudioDocuments o = (TLInputMessagesFilterAudioDocuments) object;

        return true;
    }
}
