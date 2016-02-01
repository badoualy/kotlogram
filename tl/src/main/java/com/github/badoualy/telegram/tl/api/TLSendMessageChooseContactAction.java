package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLSendMessageChooseContactAction extends TLAbsSendMessageAction {
    public static final int CONSTRUCTOR_ID = 0x628cbc6f;

    public TLSendMessageChooseContactAction() {
    }

    @Override
    public String toString() {
        return "sendMessageChooseContactAction#628cbc6f";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
