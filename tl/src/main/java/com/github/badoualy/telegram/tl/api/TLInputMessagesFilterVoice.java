package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMessagesFilterVoice extends TLAbsMessagesFilter {

    public static final int CONSTRUCTOR_ID = 0x50f5c392;

    private final String _constructor = "inputMessagesFilterVoice#50f5c392";

    public TLInputMessagesFilterVoice() {
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
