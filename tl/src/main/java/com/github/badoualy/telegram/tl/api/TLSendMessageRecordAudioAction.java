package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLSendMessageRecordAudioAction extends TLAbsSendMessageAction {

    public static final int CONSTRUCTOR_ID = 0xd52f73f7;

    private final String _constructor = "sendMessageRecordAudioAction#d52f73f7";

    public TLSendMessageRecordAudioAction() {
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
