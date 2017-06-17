package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLSendMessageGamePlayAction extends TLAbsSendMessageAction {

    public static final int CONSTRUCTOR_ID = 0xdd6a8f48;

    private final String _constructor = "sendMessageGamePlayAction#dd6a8f48";

    public TLSendMessageGamePlayAction() {
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
