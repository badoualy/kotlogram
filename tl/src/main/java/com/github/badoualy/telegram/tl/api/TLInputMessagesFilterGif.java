package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMessagesFilterGif extends TLAbsMessagesFilter {
    public static final int CLASS_ID = 0xffc86587;

    public TLInputMessagesFilterGif() {
    }

    @Override
    public String toString() {
        return "inputMessagesFilterGif#ffc86587";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
