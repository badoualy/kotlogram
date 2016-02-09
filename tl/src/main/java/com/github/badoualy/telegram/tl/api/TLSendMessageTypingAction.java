package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLSendMessageTypingAction extends TLAbsSendMessageAction {
    public static final int CONSTRUCTOR_ID = 0x16bf744e;

    public TLSendMessageTypingAction() {
    }

    @Override
    public String toString() {
        return "sendMessageTypingAction#16bf744e";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLSendMessageTypingAction)) return false;
        if (object == this) return true;

        TLSendMessageTypingAction o = (TLSendMessageTypingAction) object;

        return true;
    }
}
