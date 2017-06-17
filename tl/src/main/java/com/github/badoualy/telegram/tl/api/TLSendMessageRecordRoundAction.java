package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLSendMessageRecordRoundAction extends TLAbsSendMessageAction {

    public static final int CONSTRUCTOR_ID = 0x88f27fbc;

    private final String _constructor = "sendMessageRecordRoundAction#88f27fbc";

    public TLSendMessageRecordRoundAction() {
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
