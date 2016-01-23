package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputVideoEmpty extends TLAbsInputVideo {
    public static final int CLASS_ID = 0x5508ec75;

    public TLInputVideoEmpty() {
    }

    @Override
    public String toString() {
        return "inputVideoEmpty#5508ec75";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
