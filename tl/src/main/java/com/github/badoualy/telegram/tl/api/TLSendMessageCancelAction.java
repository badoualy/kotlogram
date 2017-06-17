package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLSendMessageCancelAction extends TLAbsSendMessageAction {

    public static final int CONSTRUCTOR_ID = 0xfd5ec8f5;

    private final String _constructor = "sendMessageCancelAction#fd5ec8f5";

    public TLSendMessageCancelAction() {
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
