package com.github.badoualy.telegram.tl.api.messages;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLStickerSetInstallResultSuccess extends TLAbsStickerSetInstallResult {

    public static final int CONSTRUCTOR_ID = 0x38641628;

    private final String _constructor = "messages.stickerSetInstallResultSuccess#38641628";

    public TLStickerSetInstallResultSuccess() {
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
