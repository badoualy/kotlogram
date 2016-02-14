package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMessagesFilterAudio extends TLAbsMessagesFilter {
    public static final int CONSTRUCTOR_ID = 0xcfc87522;

    private final String _constructor = "inputMessagesFilterAudio#cfc87522";

    public TLInputMessagesFilterAudio() {
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
        if (!(object instanceof TLInputMessagesFilterAudio)) return false;
        if (object == this) return true;

        TLInputMessagesFilterAudio o = (TLInputMessagesFilterAudio) object;

        return true;
    }
}
