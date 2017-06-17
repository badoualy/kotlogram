package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPhoneCallDiscardReasonHangup extends TLAbsPhoneCallDiscardReason {

    public static final int CONSTRUCTOR_ID = 0x57adc690;

    private final String _constructor = "phoneCallDiscardReasonHangup#57adc690";

    public TLPhoneCallDiscardReasonHangup() {
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
