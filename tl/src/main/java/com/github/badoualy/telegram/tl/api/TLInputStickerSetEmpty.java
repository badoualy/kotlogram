package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputStickerSetEmpty extends TLAbsInputStickerSet {

    public static final int CONSTRUCTOR_ID = 0xffb62b95;

    private final String _constructor = "inputStickerSetEmpty#ffb62b95";

    public TLInputStickerSetEmpty() {
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
