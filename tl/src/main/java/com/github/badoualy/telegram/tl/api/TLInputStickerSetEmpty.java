package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputStickerSetEmpty extends TLAbsInputStickerSet {
    public static final int CLASS_ID = 0xffb62b95;

    public TLInputStickerSetEmpty() {
    }

    @Override
    public String toString() {
        return "inputStickerSetEmpty#ffb62b95";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
