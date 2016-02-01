package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMessagesFilterAudioDocuments extends TLAbsMessagesFilter {
    public static final int CONSTRUCTOR_ID = 0x5afbf764;

    public TLInputMessagesFilterAudioDocuments() {
    }

    @Override
    public String toString() {
        return "inputMessagesFilterAudioDocuments#5afbf764";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
