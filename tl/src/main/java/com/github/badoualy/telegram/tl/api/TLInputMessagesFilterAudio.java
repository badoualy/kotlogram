package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMessagesFilterAudio extends TLAbsMessagesFilter {
    public static final int CONSTRUCTOR_ID = 0xcfc87522;

    public TLInputMessagesFilterAudio() {
    }

    @Override
    public String toString() {
        return "inputMessagesFilterAudio#cfc87522";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
