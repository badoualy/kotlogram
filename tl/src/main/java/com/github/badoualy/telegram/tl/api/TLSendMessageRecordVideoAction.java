package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLSendMessageRecordVideoAction extends TLAbsSendMessageAction {
    public static final int CONSTRUCTOR_ID = 0xa187d66f;

    public TLSendMessageRecordVideoAction() {
    }

    @Override
    public String toString() {
        return "sendMessageRecordVideoAction#a187d66f";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLSendMessageRecordVideoAction)) return false;
        if (object == this) return true;

        TLSendMessageRecordVideoAction o = (TLSendMessageRecordVideoAction) object;

        return true;
    }
}
